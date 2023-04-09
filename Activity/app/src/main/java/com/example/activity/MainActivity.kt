package com.example.activity

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.os.Bundle
import android.widget.Toast
import android.widget.Button
import android.widget.EditText
import android.view.View
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContracts
import android.app.Activity
import android.net.Uri
import android.provider.Settings
import androidx.core.content.ContextCompat
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat



class MainActivity : AppCompatActivity() ,View.OnClickListener{
    private lateinit var editText: EditText
    private val selfSubActivityLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val editedText = result.data?.getStringExtra("Edited")
            editText.setText(editedText)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("state", "onCreate() called")
        // Récupération d'une référence à l'élément EditText
        editText = findViewById(R.id.editText)
        // Récupération d'une référence à l'élément Button
        val button = findViewById<Button>(R.id.btnWhatEdited)
        // Déclaration de l'écouteur d'événement clic
        button.setOnClickListener {
            // Récupération du texte saisi dans le champ de texte
            val inputText = editText.text.toString()
            // Affichage d'un message contenant le texte saisi
            Toast.makeText(this, "Le texte saisi est : $inputText", Toast.LENGTH_SHORT).show()
        }
        // Set click listener for btnSelfSubActivity
        findViewById<Button>(R.id.btnSelfSubActivite).setOnClickListener(this)
        // Check if the activity was started as a sub-activity
        if (intent.hasExtra("self-sub-activity")) {
            Toast.makeText(this, "self-sub-activity", Toast.LENGTH_SHORT).show()
        }
        val btnPlanifActivity = findViewById<Button>(R.id.btnPlanifActivity)
        btnPlanifActivity.setOnClickListener {
            val intent = Intent(this, PlanifiedActivities::class.java)
            startActivity(intent)
        }
        findViewById<Button>(R.id.btnGotoGoogle).setOnClickListener(this)
        findViewById<Button>(R.id.btnCallUrgence).setOnClickListener(this)
        findViewById<Button>(R.id.btnAppSetting).setOnClickListener(this)
        findViewById<Button>(R.id.btnWifiSetting).setOnClickListener(this)

        val button2 = findViewById<Button>(R.id.btnTpforward)
        button2.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnSelfSubActivite -> {
                val intent = Intent(this, this::class.java)
                intent.putExtra("self-sub-activity", "yet")
                selfSubActivityLauncher.launch(intent)
            }
        }
        if (v != null) {
            when (v.id) {
                R.id.btnGotoGoogle -> {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"))
                    startActivity(intent)
                }
                R.id.btnAppSetting -> {
                    val intent = Intent(Settings.ACTION_APPLICATION_SETTINGS)
                    startActivity(intent)
                }
                R.id.btnWifiSetting -> {
                    val intent = Intent(Settings.ACTION_WIFI_SETTINGS)
                    startActivity(intent)
                }
                R.id.btnCallUrgence -> {
                    makePhoneCall("112") // Replace with the desired phone number
                }
            }
        }


    }
    private val MY_PERMISSIONS_REQUEST_CALL_PHONE = 123
    companion object {
        private const val REQUEST_CALL_PHONE_PERMISSION = 1
    }
    private fun makePhoneCall(phoneNumber: String) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE), REQUEST_CALL_PHONE_PERMISSION)
        }
        else {
            // Permission has already been granted, make the phone call
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:$phoneNumber"))
            startActivity(intent)
        }
    }
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>,
                                            grantResults: IntArray) {
        when (requestCode) {
            MY_PERMISSIONS_REQUEST_CALL_PHONE -> {
                // If request is cancelled, the result arrays are empty
                if (grantResults.isNotEmpty() &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission granted, make the phone call
                    makePhoneCall("112") // Replace with the desired phone number
                } else {
                    // Permission denied, show a toast or dialog to inform the user
                    Toast.makeText(this, "Phone call permission denied", Toast.LENGTH_SHORT).show()
                }
                return
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
    override fun finish() {
        val intent = Intent().apply {
            putExtra("Edited", editText.text.toString())
        }
        setResult(Activity.RESULT_OK, intent)
        super.finish()
    }

    override fun onStart() {
            super.onStart()
            Log.i("state", "onStart() called")
        }

    override fun onResume() {
            super.onResume()
            Log.i("state", "onResume() called")
        }

    override fun onPause() {
            super.onPause()
            Log.i("state", "onPause() called")
        }

    override fun onStop() {
            super.onStop()
            Log.i("state", "onStop() called")
        }

    override fun onDestroy() {
            super.onDestroy()
            Log.i("state", "onDestroy() called")
        }
}

