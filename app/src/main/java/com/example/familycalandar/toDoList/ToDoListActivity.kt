package com.example.familycalandar.toDoList

import android.content.Intent
import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.familycalandar.R
import com.example.familycalandar.task.ToDoAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ToDoListActivity : AppCompatActivity() {


    private lateinit var toDoList : MutableList<ToDo>
    private lateinit var adapterToDo : ToDoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do_list)

        val recyclerView = findViewById<RecyclerView>(R.id.rv_ToDoList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        toDoList = mutableListOf<ToDo>(
            ToDo(false,"Appeler la banque"),
            ToDo(false,"Faire les courses"),
            ToDo(false,"Promener le chien"),
            ToDo(false,"Nettoyer la litière"),
            ToDo(false,"Appeler maman"),
            ToDo(false,"Déposer Hugo au centre aéré"),
            ToDo(false,"Sortir les poubelles"),
            ToDo(false,"Nettoyer le garage"),
            ToDo(false,"Appeler le jardinier"),
        )



        recyclerView.adapter = ToDoAdapter(toDoList)
        adapterToDo = recyclerView.adapter as ToDoAdapter

        val deleteToDoTask : FloatingActionButton = findViewById(R.id.btn_deleteToDoTask)
        deleteToDoTask.setOnClickListener{
            val dialog = AlertDialog.Builder(this)
                .setTitle("Supprimer les tâches")
                .setMessage("Voulez-vous vraiment supprimer ces tâches ?")
                .setPositiveButton("Oui") { dialog, which ->
                    var temp : ArrayList<ToDo> = ArrayList()
                    for(toDo in toDoList){
                        if (toDo.isSelected){
                            temp.add(toDo)
                        }
                    }
                    toDoList.removeAll(temp)
                    adapterToDo.notifyDataSetChanged()

                    Toast.makeText(this, "Tâche(s) supperimée(s) avec succès", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Non", null)
                .show()
        }

        val addToDoTask: FloatingActionButton = findViewById(R.id.btn_addToDoTask)
        addToDoTask.setOnClickListener {
            showAddingTaskDialog()
        }
    }



    private fun showAddingTaskDialog() {
        val view = View.inflate(this, R.layout.dialog_todo_add, null)
        val alert = AlertDialog.Builder(this)
            .setTitle("Ajouter une tâche")
            .setView(view)
            .setPositiveButton("Ajouter") { _, _
                -> confirmAddTask(view.findViewById<EditText>(R.id.edtTxt_ToDoName).text.toString()) }
            .setNegativeButton("Annuler", null)
            .show()
    }

    private fun confirmAddTask(name: String) {
        /** Suppression des notes pour lesquelles l'attribut "selected" est true **/
        toDoList.add(ToDo(false, name))
        adapterToDo.notifyDataSetChanged()
        Toast.makeText(this, "Tâche ajoutée avec succès.",
            Toast.LENGTH_SHORT).show()
    }
}