package com.example.familycalandar.document

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.familycalandar.MainActivity
import com.example.familycalandar.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DocumentsListViewActivity : AppCompatActivity() {
    private lateinit var DocumentList : MutableList<DocumentModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_documents_list_view)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val recyclerView = findViewById<RecyclerView>(R.id.documentRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        DocumentList = mutableListOf(DocumentModel("Passeport") , DocumentModel("Carte Identité"))

        recyclerView.adapter = DocumentAdapter(DocumentList) {
            val intent = Intent(this, CreateDocumentActivity::class.java)
            startActivity(intent)
        }

        val addMenuButton: FloatingActionButton = findViewById(R.id.addDocumentButton)
        addMenuButton.setOnClickListener {
            val intent = Intent(this, CreateDocumentActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
