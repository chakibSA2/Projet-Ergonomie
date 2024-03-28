package com.example.familycalandar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class StartupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedPreferences = getSharedPreferences("UserDetails", MODE_PRIVATE)
        val isLoggedIn = sharedPreferences.getBoolean("IsLoggedIn", true)
        val intent = if (isLoggedIn) {
            Intent(this, HomepageActivity::class.java)
        } else {
            Intent(this, MainActivity::class.java)
        }
        startActivity(intent)
        finish()
    }
}