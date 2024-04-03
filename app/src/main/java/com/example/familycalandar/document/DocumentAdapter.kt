package com.example.familycalandar.document

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.familycalandar.R

class DocumentAdapter(private val DocumentList: MutableList<DocumentModel>, private val onDocumentClickListener: (DocumentModel) -> Unit) : RecyclerView.Adapter<DocumentAdapter.DocumentViewHolder>() {

    // Fournit une référence aux vues pour chaque élément de données
    class DocumentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var DocumentNom: TextView = itemView.findViewById(R.id.NomDocument)
    }

    // Crée de nouvelles vues (invoquées par le gestionnaire de layout)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DocumentViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_document, parent, false)
        return DocumentViewHolder(itemView)
    }

    // Remplace le contenu d'une vue (invoquée par le gestionnaire de layout)
    override fun onBindViewHolder(holder: DocumentViewHolder, position: Int) {
        val currentItem = DocumentList[position]
        holder.DocumentNom.text = currentItem.Nom
        holder.itemView.setOnClickListener {
            onDocumentClickListener(currentItem)
        }
        holder.itemView.findViewById<ImageView>(R.id.deleteDocument).setOnClickListener {
            // Afficher AlertDialog pour confirmer la suppression
            AlertDialog.Builder(holder.itemView.context)
                .setTitle("Supprimer le document")
                .setMessage("Êtes-vous sûr de vouloir supprimer ce document ?")
                .setPositiveButton(android.R.string.yes) { dialog, which ->
                    DocumentList.removeAt(position)
                    notifyItemRemoved(position)
                    notifyItemRangeChanged(position, DocumentList.size)
                }
                .setNegativeButton(android.R.string.no, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show()
        }
    }

    // Retourne la taille de votre liste de données
    override fun getItemCount() = DocumentList.size
}