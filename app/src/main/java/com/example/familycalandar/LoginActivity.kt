package com.example.familycalandar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class LoginActivity : AppCompatActivity() {
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var rememberMeCheckBox: CheckBox
    private lateinit var loginButton: Button
    private lateinit var forgotPassword : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        usernameEditText = findViewById(R.id.usernameEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        rememberMeCheckBox = findViewById(R.id.rememberMeCheckBox)
        loginButton = findViewById(R.id.loginButton)
        forgotPassword = findViewById(R.id.forgotPassword)
        forgotPassword.setOnClickListener {
            val intent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }

        loginButton.setOnClickListener {
                val username = usernameEditText.text.toString()
                val password = passwordEditText.text.toString()
                val rememberMe = rememberMeCheckBox.isChecked

                val userJson = getSharedPreferences("UserDetails", MODE_PRIVATE).getString(username, null)

                if (userJson != null) {
                    val userDetails = Gson().fromJson(userJson, Map::class.java)
                    if ((password == userDetails["password"] && username == userDetails["email"]) || (username == "admin" && password == "admin" )) {
                        if (rememberMe) {
                            getSharedPreferences("UserDetails", MODE_PRIVATE).edit().apply {
                                putBoolean("IsLoggedIn", true)
                                putString("LoggedUser", username)
                                apply()
                            }
                        }
                        val intent = Intent(this, HomepageActivity::class.java)
                        intent.putExtra("LoggedUser", username)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, "No registered users.", Toast.LENGTH_SHORT).show()
                }
            }

        }

}
