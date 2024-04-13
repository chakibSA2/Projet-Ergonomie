package com.example.familycalandar.recette


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.familycalandar.R

class RecetteAdapter(private val recettesList: MutableList<RecetteModel>, private val onItemClick: (RecetteModel) -> Unit) :
    RecyclerView.Adapter<RecetteAdapter.RecetteViewHolder>() {

    class RecetteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var recetteNom: TextView = itemView.findViewById(R.id.tvTitle)
        var recetteDescription: TextView = itemView.findViewById(R.id.tvDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecetteViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.activity_recettes, parent, false)
        return RecetteViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecetteViewHolder, position: Int) {
        val currentRecette = recettesList[position]
        holder.recetteNom.text = currentRecette.nom
        holder.recetteDescription.text = currentRecette.description
        holder.itemView.setOnClickListener {
            onItemClick(recettesList[position])
        }
        holder.itemView.findViewById<ImageView>(R.id.deleteDocument).setOnClickListener {
            // Afficher AlertDialog pour confirmer la suppression
            AlertDialog.Builder(holder.itemView.context)
                .setTitle("Supprimer la recette")
                .setMessage("Êtes-vous sûr de vouloir supprimer cette recette ?")
                .setPositiveButton(android.R.string.yes) { dialog, which ->
                    recettesList.removeAt(position)
                    notifyItemRemoved(position)
                    notifyItemRangeChanged(position, recettesList.size)
                }
                .setNegativeButton(android.R.string.no, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show()
        }
    }

    override fun getItemCount() = recettesList.size
}
