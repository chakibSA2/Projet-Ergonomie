package com.example.familycalandar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TravelsListViewActivity : AppCompatActivity() {
    private lateinit var travelList : MutableList<TravelModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_travels_list_view)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val detailsParis = listOf(
            TravelDetailsModel("Vol aller-retour", "350€"),
            TravelDetailsModel("Hôtel 5 nuits", "500€"),
            TravelDetailsModel("Pass musées", "60€"),
            TravelDetailsModel("Repas", "150€"),
            TravelDetailsModel("Transport sur place", "80€")
        )

        val detailsTokyo = listOf(
            TravelDetailsModel("Vol aller-retour", "750€"),
            TravelDetailsModel("Airbnb 7 nuits", "700€"),
            TravelDetailsModel("JR Pass", "250€"),
            TravelDetailsModel("Repas", "300€"),
            TravelDetailsModel("Visites diverses", "200€")
        )

        val recyclerView = findViewById<RecyclerView>(R.id.voyagesRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        travelList = mutableListOf(TravelModel("Voyage à Paris", "1140€", detailsParis) , TravelModel("Maroc", "Budget 1500€",detailsTokyo))

        recyclerView.adapter = TravelsAdapter(travelList) {
            val intent = Intent(this, TravelViewActivity::class.java)
            startActivity(intent)
        }

        val addMenuButton: FloatingActionButton = findViewById(R.id.addMenuButton)
        addMenuButton.setOnClickListener {
            val intent = Intent(this, CreateTravelActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}