package com.example.fitme

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ActivityOnboarding02 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding02)

        // Go button → Next Onboarding
        findViewById<Button>(R.id.go_button).setOnClickListener {
            val intent = Intent(this, ActivityOnboarding03::class.java)
            startActivity(intent)
            finish()
        }

        // Skip button → Home Page
        findViewById<Button>(R.id.skip_button).setOnClickListener {
            val intent = Intent(this, HomePage::class.java)
            startActivity(intent)
            finish()
        }
    }
}
