package com.example.fitme

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class ActivityFindFriends : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_friends)

        val bottomNav = findViewById<BottomNavigationView>(R.id.navigation_bar)

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    // TODO: Navigate to Home Activity
                    true
                }
                R.id.nav_my_network -> {
                    // TODO: Stay in Find Friends
                    true
                }
                R.id.nav_notification -> {
                    // TODO: Navigate to Notification Activity
                    true
                }
                R.id.nav_profile -> {
                    // TODO: Navigate to Profile Activity
                    true
                }
                R.id.nav_settings -> {
                    // TODO: Navigate to Settings Activity
                    true
                }
                else -> false
            }
        }
    }
}
