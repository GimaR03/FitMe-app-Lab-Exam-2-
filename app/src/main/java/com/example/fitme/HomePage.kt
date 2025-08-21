package com.example.fitme

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.navigation_bar)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    true // Stay on HomePage
                }
                R.id.nav_my_network -> {
                    false
                }
                R.id.nav_notification -> {
                    false
                }
                R.id.nav_profile -> {
                    val intent = Intent(this, ActivityProfile::class.java)
                    startActivity(intent)
                    true
                }
                R.id.nav_settings -> {
                    false
                }
                else -> false
            }
        }
        bottomNavigationView.selectedItemId = R.id.nav_home
    }
}