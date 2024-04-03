package com.example.familycalandar.document

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.familycalandar.R

class LoginDocumentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_document)

        val pinEditText: EditText = findViewById(R.id.Pin)
        val submitPinButton: Button = findViewById(R.id.SubmitPin)

        submitPinButton.setOnClickListener {
            val pin = pinEditText.text.toString()
            if (pin == "1234") {
                val intent = Intent(this, DocumentsListViewActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Code PIN incorrect", Toast.LENGTH_SHORT).show()
            }
        }
    }
}