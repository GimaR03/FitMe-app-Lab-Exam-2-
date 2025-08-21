package com.example.fitme

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ActivitySigninPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin_page)

        // Optional: Make "Sign up" clickable to go back to Signup Page
        findViewById<TextView>(R.id.sign_up_link).setOnClickListener {
            val intent = Intent(this, ActivitySignupPage::class.java)
            startActivity(intent)
        }

        // Make "Sign in" button clickable to open Onboarding01
        findViewById<Button>(R.id.sign_in_button).setOnClickListener {
            val intent = Intent(this, ActivityOnboarding01::class.java)
            startActivity(intent)
        }
    }
}