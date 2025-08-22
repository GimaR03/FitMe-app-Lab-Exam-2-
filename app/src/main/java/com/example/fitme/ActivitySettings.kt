package com.example.fitme

import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GestureDetectorCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class ActivitySettings : AppCompatActivity() {
    private lateinit var gestureDetector: GestureDetectorCompat
    private lateinit var navigationBar: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        navigationBar = findViewById(R.id.navigation_bar)
        navigationBar.visibility = android.view.View.GONE

        gestureDetector = GestureDetectorCompat(this, GestureListener())
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
                navigationBar.visibility = android.view.View.VISIBLE
                navigationBar.animate().translationY(0f).duration = 300
                return true
            } else if (diffY > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                navigationBar.animate().translationY(navigationBar.height.toFloat()).duration = 300
                navigationBar.postDelayed({
                    navigationBar.visibility = android.view.View.GONE
                }, 300)
                return true
            }
            return false
        }
    }
}