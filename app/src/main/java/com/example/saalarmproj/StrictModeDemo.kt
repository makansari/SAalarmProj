package com.example.saalarmproj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode

class StrictModeDemo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_strict_mode_demo)


        if(BuildConfig.DEBUG){

            StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder()
                .detectDiskReads()
                .detectDiskWrites()
                .detectNetwork()
                .penaltyLog()
                .penaltyDeath()
                .build()
            )


            StrictMode.setVmPolicy(StrictMode.VmPolicy.Builder()
                .detectLeakedSqlLiteObjects()
                .detectLeakedClosableObjects()
                .penaltyLog()
                .penaltyDeath()
                .build()

            )

        }
    }
}