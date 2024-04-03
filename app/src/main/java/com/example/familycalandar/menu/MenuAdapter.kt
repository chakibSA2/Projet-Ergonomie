package com.example.familycalandar.menu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.familycalandar.R

class MenuAdapter(private val menuList: List<MenuModel>,
                  private val onMenuClickListener: (MenuModel) -> Unit) : RecyclerView
                      .Adapter<MenuAdapter.MenuViewHolder>() {

    // Fournit une référence aux vues pour chaque élément de données
    class MenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var menuTitle: TextView = itemView.findViewById(R.id.menuTitle)
        var menuDate: TextView = itemView.findViewById(R.id.menuDate)
    }

    // Crée de nouvelles vues (invoquées par le gestionnaire de layout)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_menu, parent, false)
        return MenuViewHolder(itemView)
    }

    // Remplace le contenu d'une vue (invoquée par le gestionnaire de layout)
    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val currentItem = menuList[position]
        holder.menuTitle.text = currentItem.title
        holder.menuDate.text = currentItem.date
        holder.itemView.setOnClickListener {
            onMenuClickListener(currentItem)
        }
    }

    // Retourne la taille de votre liste de données
    override fun getItemCount() = menuList.size
}