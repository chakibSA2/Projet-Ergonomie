package com.example.familycalandar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.google.android.material.floatingactionbutton.FloatingActionButton
class CreateTravelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_travel)

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
            val detailBudget = detailView.findViewById<EditText>(R.id.detailBudget).text.toString()
            if (detailBudget.isNotEmpty()) {
                totalBudget += detailBudget.toDouble()
            }
        }
        val tvTotalBudget = findViewById<TextView>(R.id.tvTotalBudget)
        tvTotalBudget.text = "Budget Total : " + totalBudget.toString() + "€"
    }
}