package com.example.familycalandar

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CreateAccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_account_activity)


        val nom: EditText = findViewById(R.id.Nom)
        val prenom: EditText = findViewById(R.id.Prenom)
        val email: EditText = findViewById(R.id.Email)
        val password: EditText = findViewById(R.id.Password)
        val spinner: Spinner = findViewById(R.id.UserType)

        val userTypeOptions =
            arrayOf("Type de profil : ", "Quotidien", "Associatif", "Voyage", "Etudes", "Famille")
        spinner.adapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, userTypeOptions)

        val buttonSubmit: Button = findViewById(R.id.buttonSubmit)
        buttonSubmit.setOnClickListener {
            val userDetails = mapOf(
                "nom" to nom.text.toString(),
                "prenom" to prenom.text.toString(),
                "email" to email.text.toString(),
                "password" to password.text.toString(),
                "typeUtilisateur" to spinner.selectedItem.toString()
            )
            val userJson = Gson().toJson(userDetails)

            val sharedPreferences = getSharedPreferences("UserDetails", Context.MODE_PRIVATE)
            val emailKey = email.text.toString()
            sharedPreferences.edit().apply { putString(emailKey, userJson).apply() }

            Toast.makeText(this, "Votre compte a bien été créé", Toast.LENGTH_LONG).show()

            val intent = Intent(this, HomepageActivity::class.java)
            intent.putExtra("LoggedUser", emailKey)
            startActivity(intent)
        }
    }
}

