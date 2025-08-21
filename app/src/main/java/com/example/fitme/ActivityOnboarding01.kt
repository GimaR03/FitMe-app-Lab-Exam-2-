package com.example.fitme

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ActivityOnboarding01 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding01)

        findViewById<Button>(R.id.lets_start_button).setOnClickListener {
            val intent = Intent(this, ActivityOnboarding02::class.java)
            startActivity(intent)
            finish()
        }
    }
}