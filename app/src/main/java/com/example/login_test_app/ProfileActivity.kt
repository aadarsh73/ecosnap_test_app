package com.example.login_test_app

import RetrofitClient
import android.content.Context
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile)
        val sharedPreferences = getSharedPreferences("login_test_app", Context.MODE_PRIVATE)
        val token = sharedPreferences.getString("user_token", "")
        val name = findViewById<TextView>(R.id.name)
        val email = findViewById<TextView>(R.id.email)
        val shToken = findViewById<TextView>(R.id.token)

        shToken.text = token.toString()

        token?.let { RetrofitClient.instance.getUserDetails(it) }
            ?.enqueue(object : Callback<UserDetails> {
                override fun onResponse(call: Call<UserDetails>, response: Response<UserDetails>) {
                    if (response.isSuccessful) {
                        val userDetails = response.body()
                        Toast.makeText(this@ProfileActivity, userDetails.toString(), Toast.LENGTH_SHORT).show()
                        // Update your UI with the user details
                        // For example, set text to TextViews
                        name.text = userDetails?.username
                        email.text = userDetails?.email
                        shToken.text = token
                    } else {
                        // Handle error
                        Toast.makeText(
                            this@ProfileActivity,
                            "Error fetching user details",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                override fun onFailure(call: Call<UserDetails>, t: Throwable) {
                    // Handle failure
                    Toast.makeText(this@ProfileActivity, "Network error", Toast.LENGTH_SHORT).show()
                }
            })


    }

}