package com.example.fitme

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ActivityLaunchScreen01 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launchscreen_01)

        // Delay for 2 seconds before launching the next activity
        CoroutineScope(Dispatchers.Main).launch {
            delay(2000) // 2000 milliseconds = 2 seconds
            val intent = Intent(this@ActivityLaunchScreen01, ActivityLaunchScreen02::class.java)
            startActivity(intent)
            finish() // Close the current activity
        }
    }
}