package com.example.saalarmproj

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        buttonStart.setOnClickListener {

            Toast.makeText(this,"buttonclicked",Toast.LENGTH_SHORT).show()

            var time = (editTextInput.text.toString()).toInt()
            var myIntent = Intent(this,PhoneBookDemo::class.java)
            var pi = PendingIntent.getActivity(this,123,myIntent,0)

            var alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager

            alarmManager.set(AlarmManager.RTC_WAKEUP,
                    System.currentTimeMillis() + (time * 1000),pi)

        }
    }
}