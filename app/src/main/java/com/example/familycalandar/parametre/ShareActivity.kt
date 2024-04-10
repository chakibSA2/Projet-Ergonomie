package com.example.familycalandar.parametre

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.familycalandar.R
import com.example.familycalandar.SharedFunction
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ShareActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share)

        val btnShare : FloatingActionButton = findViewById(R.id.btnShare)
        btnShare.setOnClickListener {
          SharedFunction.shareLink(this,"partage d'information","https://lien_bidon")
        }
    }
}