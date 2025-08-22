package com.example.fitme

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ActivityOnboarding03 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding03)

        findViewById<Button>(R.id.go_button).setOnClickListener {
            val intent = Intent(this, HomePage::class.java) // Replace with your target activity
            startActivity(intent)
            finish()
        }
    }
}