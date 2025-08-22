package com.example.fitme

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class ActivityFindFriends : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_friends)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.navigation_bar)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    // Navigate to Home activity
                    true
                }
                R.id.nav_my_network -> {
                    // Already on Find Friends
                    true
                }
                R.id.nav_profile -> {
                    // Navigate to Profile activity
                    true
                }
                else -> false
            }
        }
    }
}