package com.example.familycalandar.travel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.familycalandar.R

class TravelsAdapter(private val TravelList: MutableList<TravelModel>, private val onVoyageClickListener: (TravelModel) -> Unit) : RecyclerView.Adapter<TravelsAdapter.VoyageViewHolder>() {

    // Fournit une référence aux vues pour chaque élément de données
    class VoyageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var voyageNom: TextView = itemView.findViewById(R.id.voyageNom)
        var voyageBudget: TextView = itemView.findViewById(R.id.voyageBudget)
    }

    // Crée de nouvelles vues (invoquées par le gestionnaire de layout)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VoyageViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_travel, parent, false)
        return VoyageViewHolder(itemView)
    }

    // Remplace le contenu d'une vue (invoquée par le gestionnaire de layout)
    override fun onBindViewHolder(holder: VoyageViewHolder, position: Int) {
        val currentItem = TravelList[position]
        holder.voyageNom.text = currentItem.nom
        holder.voyageBudget.text = currentItem.budget
        holder.itemView.setOnClickListener {
            onVoyageClickListener(currentItem)
        }
        holder.itemView.findViewById<ImageView>(R.id.deleteVoyage).setOnClickListener {
            // Afficher AlertDialog pour confirmer la suppression
            AlertDialog.Builder(holder.itemView.context)
                .setTitle("Supprimer le voyage")
                .setMessage("Êtes-vous sûr de vouloir supprimer ce voyage ?")
                .setPositiveButton(android.R.string.yes) { dialog, which ->
                    TravelList.removeAt(position)
                    notifyItemRemoved(position)
                    notifyItemRangeChanged(position, TravelList.size)
                }
                .setNegativeButton(android.R.string.no, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show()
        }
    }

    // Retourne la taille de votre liste de données
    override fun getItemCount() = TravelList.size
}