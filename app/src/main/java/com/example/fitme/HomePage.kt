package com.example.fitme

import android.content.Intent
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GestureDetectorCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomePage : AppCompatActivity() {
    private lateinit var gestureDetector: GestureDetectorCompat
    private lateinit var navigationBar: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        navigationBar = findViewById(R.id.navigation_bar)
        navigationBar.visibility = View.VISIBLE

        gestureDetector = GestureDetectorCompat(this, GestureListener())

        // Set up navigation listener
        navigationBar.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    // Already on Home
                    true
                }
                R.id.nav_my_network -> {
                    startActivity(Intent(this, ActivityFindFriends::class.java))
                    finish()
                    true
                }
                R.id.nav_notification -> {
                    startActivity(Intent(this, ActivityNotification::class.java))
                    finish()
                    true
                }
                R.id.nav_profile -> {
                    startActivity(Intent(this, ActivityProfile::class.java))
                    finish()
                    true
                }
                R.id.nav_settings -> {
                    startActivity(Intent(this, ActivitySettings::class.java))
                    finish()
                    true
                }
                else -> false
            }
        }
        navigationBar.selectedItemId = R.id.nav_home
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return if (gestureDetector.onTouchEvent(event)) {
            true
        } else {
            super.onTouchEvent(event)
        }
    }

    private inner class GestureListener : GestureDetector.SimpleOnGestureListener() {
        private val SWIPE_THRESHOLD = 100
        private val SWIPE_VELOCITY_THRESHOLD = 100

        override fun onDown(e: MotionEvent): Boolean {
            return true
        }

        override fun onFling(
            e1: MotionEvent?,
            e2: MotionEvent,
            velocityX: Float,
            velocityY: Float
        ): Boolean {
            val diffY = e2.y - (e1?.y ?: 0f)
            if (diffY < -SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                if (navigationBar.visibility == View.GONE) {
                    navigationBar.visibility = View.VISIBLE
                    navigationBar.animate().translationY(0f).duration = 300
                }
                return true
            } else if (diffY > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                if (navigationBar.visibility == View.VISIBLE) {
                    navigationBar.animate().translationY(navigationBar.height.toFloat()).duration = 300
                    navigationBar.postDelayed({
                        navigationBar.visibility = View.GONE
                    }, 300)
                }
                return true
            }
            return false
        }
    }
}