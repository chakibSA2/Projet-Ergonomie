package com.example.familycalandar

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.familycalandar.document.DocumentsListViewActivity
import com.example.familycalandar.menu.MenuViewActivity
import com.example.familycalandar.toDoList.ToDoListActivity
import com.example.familycalandar.travel.TravelsListViewActivity

class MainboardVoyageurActivity: AppCompatActivity() {

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainboard_traveler);

         val documents : CardView = findViewById(R.id.vgn_DocumentsVignette)
         documents.setOnClickListener {
             val intent = Intent(this, DocumentsListViewActivity::class.java)
             startActivity(intent)
         }

         val budget : CardView = findViewById(R.id.vgn_BudgetVignette)
         budget.setOnClickListener {
             val intent = Intent(this, TravelsListViewActivity::class.java)
             startActivity(intent)
         }

         val menus : CardView = findViewById(R.id.vgn_MenusVignette)
         menus.setOnClickListener {
             val intent = Intent(this, MenuViewActivity::class.java)
             startActivity(intent)
         }
    }

}
