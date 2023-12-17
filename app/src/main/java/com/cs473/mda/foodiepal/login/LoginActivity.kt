package com.cs473.mda.foodiepal.login

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.cs473.mda.foodiepal.dashboard.DashboardActivity
import com.cs473.mda.foodiepal.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupAdminAccount()
        val viewBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        binding(viewBinding)
    }

    private fun binding(views: ActivityLoginBinding) {
        views.loginNextButton.setOnClickListener {

            val username = views.loginUsernameTextView.text.toString()
            val password = views.loginPinTextView.text.toString()
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please input username and password", Toast.LENGTH_LONG).show()
            } else {
                if (isValid(username, password)) {
                    moveToDashboard()
                } else {
                    Toast.makeText(this, "Invalid Password", Toast.LENGTH_LONG).show()
                }
            }


        }
    }

    private fun moveToDashboard() {
        val intent = Intent(this, DashboardActivity::class.java)
        startActivity(intent)
    }

    fun isValid(username: String, password: String): Boolean {
        val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val savedPassowrd = sharedPreferences?.getString(username, "")
        if (savedPassowrd == null || savedPassowrd != password ) {
            return false
        }
        return true
    }

    private fun setupAdminAccount() {
        // Get SharedPreferences instance
        val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)


        if (sharedPreferences?.getString("admin", "") == null || sharedPreferences.getString("admin", "")!!.isEmpty()) {
            // Get an editor to modify preferences
            val editor = sharedPreferences.edit()

            // Store the username
            editor.putString("admin", "1234")

            // Apply changes
            editor.apply()
        }

    }
}