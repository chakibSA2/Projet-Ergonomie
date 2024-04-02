package com.example.familycalandar


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecetteAdapter(private val recettesList: List<RecetteModel>) :
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
    }

    override fun getItemCount() = recettesList.size
}
