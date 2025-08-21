package com.example.fitme

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView

class ActivityLaunchScreen04 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launchscreen_04)

        val logoImage = findViewById<ImageView>(R.id.logo_image)
        logoImage.rotation = 270f

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, ActivityLaunchScreen05::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}