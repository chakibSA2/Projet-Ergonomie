package com.example.familycalandar


import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class CreateAccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_account_activity)

        val spinner: Spinner = findViewById(R.id.UserType)
        val userTypeOptions = arrayOf("Vous etes : ","un voyageur", "un étudiant", "une mère/père de famille")
        spinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, userTypeOptions)

        val buttonSubmit: Button = findViewById(R.id.buttonSubmit)
        buttonSubmit.setOnClickListener {

        }
    }
}