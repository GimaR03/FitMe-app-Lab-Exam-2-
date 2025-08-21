package com.example.fitme

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class ActivityLaunchScreen05 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launchscreen_05)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, ActivitySignupPage::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}