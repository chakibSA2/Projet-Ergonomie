package com.example.familycalandar.menu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.familycalandar.R

class MenuAdapter(private val menuList: MutableList<MenuModel>,
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
        holder.itemView.findViewById<ImageView>(R.id.deleteDocument).setOnClickListener {
            // Afficher AlertDialog pour confirmer la suppression
            AlertDialog.Builder(holder.itemView.context)
                .setTitle("Supprimer le menu")
                .setMessage("Êtes-vous sûr de vouloir supprimer ce menu ?")
                .setPositiveButton(android.R.string.yes) { dialog, which ->
                    menuList.removeAt(position)
                    notifyItemRemoved(position)
                    notifyItemRangeChanged(position, menuList.size)
                }
                .setNegativeButton(android.R.string.no, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show()
        }
    }

    // Retourne la taille de votre liste de données
    override fun getItemCount() = menuList.size
}