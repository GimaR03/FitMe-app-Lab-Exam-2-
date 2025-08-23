package com.example.fitme

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class ActivityLaunchScreens : AppCompatActivity() {

    // Put your 5 splash/launch layouts here (use your real layout file names)
    private val layouts = arrayOf(
        R.layout.activity_launchscreen_01,
        R.layout.activity_launchscreen_02,
        R.layout.activity_launchscreen_03,
        R.layout.activity_launchscreen_04,
        R.layout.activity_launchscreen_05
    )

    private var index = 0
    private val handler = Handler(Looper.getMainLooper())
    private val delayMs = 2000L // 2 seconds between screens

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showNext()
    }

    private fun showNext() {
        if (index >= layouts.size) {
            // Done → go to next real screen (Signup/Login/Home etc.)
            startActivity(Intent(this, ActivitySignupPage::class.java))
            finish()
            return
        }

        setContentView(layouts[index])

        if (index == 0) {
            // First screen waits for user tap on logo
            // Make sure the first layout's logo ImageView has id: @+id/logo_image
            val logo = findViewById<ImageView>(R.id.logo_image)
            logo?.setOnClickListener {
                index++
                handler.postDelayed({ showNext() }, delayMs)
            }
        } else {
            // Other screens auto-advance
            index++
            handler.postDelayed({ showNext() }, delayMs)
        }
    }
}
