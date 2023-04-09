package com.example.activity

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.util.Log
import android.view.View
import android.content.Intent
import android.content.IntentFilter
import android.widget.Toast

class Receiver : BroadcastReceiver() {
    override fun onReceive(ctx: Context, intent: Intent) {
        val t = Toast.makeText(ctx, intent.extras?.getString("param"), Toast.LENGTH_SHORT)
        t.show()
    }
}

class PlanifiedActivities : AppCompatActivity() , View.OnClickListener{
    private lateinit var alarms: AlarmManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("state", "onCreate() called")
        setContentView(R.layout.activity_planified_activities)
        findViewById<Button>(R.id.btnBroadcastViaIntent).setOnClickListener(this)
        findViewById<Button>(R.id.btnDynamicBroadcastRecViaAlarm).setOnClickListener(this)
        findViewById<Button>(R.id.btnXMLStaticBroadcastRecViaAlarm).setOnClickListener(this)
        val receiver = Receiver()
        val filter = IntentFilter("ACTION_ALARM")
        registerReceiver(receiver, filter)
        alarms = getSystemService(Context.ALARM_SERVICE) as AlarmManager



    }
    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnBroadcastViaIntent -> {
                //code 1
                val intent = Intent("ACTION_ALARM")
                intent.putExtra("param", "Bonjour via Intent")
                sendBroadcast(intent)
            }
            R.id.btnDynamicBroadcastRecViaAlarm -> {
                // code 2
                val intent = Intent("ACTION_ALARM")
                intent.putExtra("param", "Bonjour via Alarm")
                val operation = PendingIntent.getBroadcast(this, 0, intent, 0)
                alarms.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 3000, operation)

            }
            R.id.btnXMLStaticBroadcastRecViaAlarm -> {
                // code 3
                val intent = Intent("ACTION_ALARM_FILTRED")
                intent.putExtra("param", "Bonjour via Alarm (reciever in xml)")
                val op = PendingIntent.getBroadcast(v.context, 0, intent, 0)
                alarms.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 3000, op)

            }
        }
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

