package com.example.fitme

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ActivitySignupPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_page)

        // Make "Sign in" clickable to open Sign-In Page
        findViewById<TextView>(R.id.sign_in_link).setOnClickListener {
            val intent = Intent(this, ActivitySigninPage::class.java)
            startActivity(intent)
        }

        // Make "Sign up" button clickable to open Onboarding01
        findViewById<Button>(R.id.sign_up_button).setOnClickListener {
            val intent = Intent(this, ActivityOnboarding01::class.java)
            startActivity(intent)
        }
    }
}