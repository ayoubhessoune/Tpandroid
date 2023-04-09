package com.example.activity


import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import androidx.constraintlayout.widget.ConstraintLayout

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val cb = findViewById<CheckBox>(R.id.check)
        cb.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                cb.text = "Cette case est cochee"
            } else {
                cb.text = "Cette case est decochee"
            }
        }
        val layout: ConstraintLayout = findViewById(R.id.Home)
        layout.setBackgroundColor(Color.BLACK)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this, Linearchoice::class.java)
            startActivity(intent)
        }

    }



}