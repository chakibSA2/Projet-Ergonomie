package com.example.familycalandar

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainboardVoyageurActivity: AppCompatActivity() {
    private lateinit var btnParametres: Button;
    private lateinit var btnGestionMenus: Button;
    private lateinit var btnListeCourses: Button;
    private lateinit var btnEmploiTemps: Button;
    private lateinit var btnVoyage: Button;
    private lateinit var btnDocuments: Button;

    // Initialize UI elements
     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainboardvoyageuractivity);
    }

}
