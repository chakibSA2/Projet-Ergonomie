package com.example.familycalandar.agenda

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CalendarView
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.familycalandar.MainboardParentsActivity
import com.example.familycalandar.MainboardVoyageurActivity
import com.example.familycalandar.R
import com.example.familycalandar.task.ToDoAdapter
import com.example.familycalandar.toDoList.ToDo
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.w3c.dom.Text

class AgendaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agenda)

        val toolbar = findViewById<Toolbar>(R.id.tb_CalendarToolbar)
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener {
            val intent = Intent(this, MainboardVoyageurActivity::class.java)
            startActivity(intent)
        }

        var calendar: CalendarView = findViewById(R.id.cld_Calendar)


        val deleteEventDocteur: ImageView = findViewById(R.id.iv_DeleteDocteur)
        val deleteEventMenu: ImageView = findViewById(R.id.iv_DeleteMenu)
        val viewDocteurEvent: TextView = findViewById(R.id.tv_EventDocteur)
        val viewMenuEvent: TextView = findViewById(R.id.tv_EventMenu)
        val addButton: FloatingActionButton = findViewById(R.id.b_addEvent)

        viewDocteurEvent.setOnClickListener {
            val view = View.inflate(this, R.layout.dialog_see_event, null)
            val dialog = AlertDialog.Builder(this)
                .setView(view)
                .setTitle("Consulter l'évènement")
                .setPositiveButton("Ok") { dialog, which ->
                    finish()
                }
                .setNegativeButton("Annuler", null)
                .show()
        }

        addButton.setOnClickListener {
            showAddingTaskDialog()
        }

        deleteEventDocteur.setOnClickListener {
            viewDocteurEvent.isVisible = false
            deleteEventDocteur.isVisible = false
        }
    }

    private fun showAddingTaskDialog() {
        val view = View.inflate(this, R.layout.dialog_add_event, null)
        val alert = AlertDialog.Builder(this)
            .setTitle("Ajouter un évènement")
            .setView(view)
            .setPositiveButton("Ajouter") { _, _
                -> confirmAddTask() }
            .setNegativeButton("Annuler", null)
            .show()
    }

    private fun confirmAddTask() {
        Toast.makeText(this, "Evènement ajouté avec succès.",
            Toast.LENGTH_SHORT).show()
    }
}
