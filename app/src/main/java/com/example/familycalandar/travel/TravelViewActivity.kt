package com.example.familycalandar.travel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.example.familycalandar.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TravelViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_travel_view)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener {
            val intent = Intent(this, TravelsListViewActivity::class.java)
            startActivity(intent)
        }

        val btnAddDetail = findViewById<Button>(R.id.btnAddDetail)
        btnAddDetail.setOnClickListener {
            addDetailField()
        }

        val fabValidate = findViewById<FloatingActionButton>(R.id.fabValidate)
        fabValidate.setOnClickListener {
            val intent = Intent(this, TravelsListViewActivity::class.java)
            startActivity(intent)
        }

        // Exemple de voyage à Paris
        val detailsParis = listOf(
            TravelDetailsModel("Vol aller-retour", "350"),
            TravelDetailsModel("Hôtel 5 nuits", "500"),
            TravelDetailsModel("Pass musées", "60"),
            TravelDetailsModel("Repas", "150"),
            TravelDetailsModel("Transport sur place", "80")
        )

        val travel = TravelModel("Voyage à Paris", "1140€", detailsParis)

        // Initialiser l'interface utilisateur avec les détails du voyage
        initializeUIWithTravelDetails(travel)
    }
    private fun initializeUIWithTravelDetails(travel: TravelModel) {
        val tvTravelName = findViewById<EditText>(R.id.editTextVoyageName)
        val tvTotalBudget = findViewById<TextView>(R.id.tvTotalBudget)

        tvTravelName.setText(travel.nom)
        tvTotalBudget.text = "Budget Total : ${travel.budget}"

        travel.details.forEach { detail ->
            addDetailField(detail)
        }
    }

    private fun addDetailField(detail: TravelDetailsModel? = null) {
        val container = findViewById<LinearLayout>(R.id.linearLayoutDetailsContainer)
        val detailView = LayoutInflater.from(this).inflate(R.layout.details_travel_item, container, false)

        val deleteButton = detailView.findViewById<ImageView>(R.id.deleteDetail)
        deleteButton.setOnClickListener {
            container.removeView(detailView)
            updateTotalBudget()
        }

        val detailName = detailView.findViewById<EditText>(R.id.detailName)
        val detailBudget = detailView.findViewById<EditText>(R.id.detailBudget)
        if (detail != null) {
            detailName.setText(detail.detail)
            detailBudget.setText(detail.prix)
        }
        detailBudget.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                updateTotalBudget()
            }
            override fun afterTextChanged(s: Editable?) {}
        })

        container.addView(detailView)
    }

    private fun updateTotalBudget() {
        val container = findViewById<LinearLayout>(R.id.linearLayoutDetailsContainer)
        var totalBudget = 0.0
        for (i in 0 until container.childCount) {
            val detailView = container.getChildAt(i)
            val detailBudgetText = detailView.findViewById<EditText>(R.id.detailBudget).text.toString()
            if (detailBudgetText.isNotEmpty()) {
                totalBudget += detailBudgetText.toDouble()
            }
        }
        val tvTotalBudget = findViewById<TextView>(R.id.tvTotalBudget)
        tvTotalBudget.text = "Budget Total : "+totalBudget.toString()+"€"
    }
}