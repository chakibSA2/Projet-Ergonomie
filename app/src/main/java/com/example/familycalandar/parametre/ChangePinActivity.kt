package com.example.familycalandar.parametre

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.familycalandar.R
import com.google.android.material.snackbar.Snackbar

class ChangePinActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_pin)

        val oldPinInput: EditText = findViewById(R.id.old_pin_input)
        val newPinInput: EditText = findViewById(R.id.new_pin_input)
        val confirmNewPinInput: EditText = findViewById(R.id.confirm_new_pin_input)
        val submitNewPin: Button = findViewById(R.id.submit_new_pin)

        submitNewPin.setOnClickListener {
            val oldPin = oldPinInput.text.toString()
            val newPin = newPinInput.text.toString()
            val confirmNewPin = confirmNewPinInput.text.toString()

            if (validatePin(oldPin, newPin, confirmNewPin)) {
                Toast.makeText(this, "Succès : Le code PIN a été changé.", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Erreur : Les informations fournies sont incorrectes.", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun validatePin(oldPin: String, newPin: String, confirmNewPin: String): Boolean {
        val correctOldPin = "12345"
        return when {
            oldPin != correctOldPin -> false
            newPin != confirmNewPin -> false
            else -> true
        }
    }
}

