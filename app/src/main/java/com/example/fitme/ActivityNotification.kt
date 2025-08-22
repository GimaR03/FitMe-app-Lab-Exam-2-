package com.example.fitme

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class ActivityNotification : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        // Optional: Add BottomNavigationView logic if this activity has its own navigation bar
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.navigation_bar)
        if (bottomNavigationView != null) {
            bottomNavigationView.setOnNavigationItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.nav_home -> {
                        val intent = Intent(this, HomePage::class.java)
                        startActivity(intent)
                        true
                    }
                    R.id.nav_my_network -> {
                        val intent = Intent(this, ActivityFindFriends::class.java)
                        startActivity(intent)
                        true
                    }
                    R.id.nav_notification -> {
                        // Already on Notification
                        true
                    }
                    R.id.nav_profile -> {
                        val intent = Intent(this, ActivityProfile::class.java)
                        startActivity(intent)
                        true
                    }
                    R.id.nav_settings -> {
                        val intent = Intent(this, ActivitySettings::class.java)
                        startActivity(intent)
                        true
                    }
                    else -> false
                }
            }
            bottomNavigationView.selectedItemId = R.id.nav_notification
        }
    }
}