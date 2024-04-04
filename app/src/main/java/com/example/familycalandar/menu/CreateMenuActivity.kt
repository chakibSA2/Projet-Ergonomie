package com.example.familycalandar.menu

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.familycalandar.R
import com.example.familycalandar.task.TasksListActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.Calendar

class CreateMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_menu)

        val validateButton: FloatingActionButton = findViewById(R.id.validate)
        validateButton.setOnClickListener {
            val intent = Intent(this, MenuViewActivity::class.java)
            startActivity(intent)
        }

        val DateButton: Button = findViewById(R.id.DateButton)
        DateButton.setOnClickListener {
            showDatePickerDialog()
        }

        val TimeButton: Button = findViewById(R.id.TimeButton)
        TimeButton.setOnClickListener {
            showTimePickerDialog()
        }
    }

    private fun showDatePickerDialog() {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this, { _, year, monthOfYear, dayOfMonth ->
        }, year, month, day)

        datePickerDialog.show()
    }

    private fun showTimePickerDialog() {
        val c = Calendar.getInstance()
        val hour = c.get(Calendar.HOUR_OF_DAY)
        val minute = c.get(Calendar.MINUTE)

        val timePickerDialog = TimePickerDialog(this, { _, hourOfDay, minute ->
            // Traitement de l'heure ici
        }, hour, minute, true)

        timePickerDialog.show()
    }
}