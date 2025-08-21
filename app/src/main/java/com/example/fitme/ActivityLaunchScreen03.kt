package com.example.fitme

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView

class ActivityLaunchScreen03 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launchscreen_03)

        val logoImage = findViewById<ImageView>(R.id.logo_image)
        logoImage.rotation = 180f

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, ActivityLaunchScreen04::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}