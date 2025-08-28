package com.example.fitme

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class ActivityLaunchScreens : AppCompatActivity() {

    // 5 splash/launch layouts (XML files inside res/layout)
    private val layouts = arrayOf(
        R.layout.activity_launchscreen_01,
        R.layout.activity_launchscreen_02,
        R.layout.activity_launchscreen_03,
        R.layout.activity_launchscreen_04,
        R.layout.activity_launchscreen_05
    )

    private var index = 0
    private val handler = Handler(Looper.getMainLooper())
    private val delayMs = 2000L // 2 seconds per screen

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showNext()
    }

    private fun showNext() {
        if (index >= layouts.size) {
            // All screens finished → go to Signup/Login page
            startActivity(Intent(this, ActivitySignupPage::class.java))
            finish()
            return
        }

        // Show current screen
        setContentView(layouts[index])

        if (index == 0) {
            // First screen: wait for user tap on logo
            val logo = findViewById<ImageView>(R.id.logo_image)
            logo?.setOnClickListener {
                index++
                handler.postDelayed({ showNext() }, delayMs)
            }
        } else {
            // Other screens: auto-advance
            index++
            handler.postDelayed({ showNext() }, delayMs)
        }
    }
}
