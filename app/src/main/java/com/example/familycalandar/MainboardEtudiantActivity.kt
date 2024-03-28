package com.example.familycalandar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainboardEtudiantActivity : AppCompatActivity() {
    private lateinit var btnParametres: Button;
    private lateinit var btnGestionMenus: Button;
    private lateinit var btnListeCourses: Button;
    private lateinit var btnEmploiTemps: Button;
    private lateinit var btnVoyage: Button;
    private lateinit var btnDocuments: Button;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainboard_etudiant)
    }
}