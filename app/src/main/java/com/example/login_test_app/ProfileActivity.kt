package com.example.login_test_app

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile)
        val name = findViewById<TextView>(R.id.name)
        val email = findViewById<TextView>(R.id.email)
        val shToken = findViewById<TextView>(R.id.token)

    }
}