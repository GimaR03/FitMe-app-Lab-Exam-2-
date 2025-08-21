package com.example.fitme

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ActivityFindFriends : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_friends)

        findViewById<Button>(R.id.invite_instagram_button).setOnClickListener {
            openAppOrWeb("com.instagram.android", "https://www.instagram.com")
        }

        findViewById<Button>(R.id.invite_facebook_button).setOnClickListener {
            openAppOrWeb("com.facebook.katana", "https://www.facebook.com")
        }

        findViewById<Button>(R.id.invite_whatsapp_button).setOnClickListener {
            openAppOrWeb("com.whatsapp", "https://www.whatsapp.com")
        }
    }

    private fun openAppOrWeb(packageName: String, webUrl: String) {
        val intent = packageManager.getLaunchIntentForPackage(packageName)
        if (intent != null) {
            startActivity(intent)
        } else {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(webUrl)))
        }
    }
}