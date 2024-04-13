package com.example.familycalandar.document

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.example.familycalandar.R
import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ViewDocumentActivity : AppCompatActivity() {
    private lateinit var editText: EditText
    private lateinit var filePickerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_document)

        editText = findViewById(R.id.NomDocument)
        filePickerButton = findViewById(R.id.documentFile)
        val documentPreview: ImageView = findViewById(R.id.documentPreview)
        val uri = Uri.parse("android.resource://${packageName}/${R.drawable.fake_id}")
        val deleteDocumentButton: Button = findViewById(R.id.deleteDocumentButton)
        documentPreview.setImageURI(uri)
        documentPreview.visibility = View.VISIBLE
        deleteDocumentButton.visibility = View.VISIBLE
        deleteDocumentButton.setOnClickListener {
            documentPreview.visibility = View.GONE
            deleteDocumentButton.visibility = View.GONE
            // Ajoutez ici toute autre logique de nettoyage nécessaire
        }
        filePickerButton.setOnClickListener {

            val intent = Intent(Intent.ACTION_GET_CONTENT).apply {
                type = "*/*"
                addCategory(Intent.CATEGORY_OPENABLE)
            }
            startActivityForResult(intent, PICK_FILE_REQUEST_CODE)
        }

        val fabValidate = findViewById<FloatingActionButton>(R.id.validate)
        fabValidate.setOnClickListener {
            val intent = Intent(this, DocumentsListViewActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_FILE_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            data?.data?.also { uri ->
                val documentPreview: ImageView = findViewById(R.id.documentPreview)
                val deleteDocumentButton: Button = findViewById(R.id.deleteDocumentButton)

                // Afficher l'aperçu et le bouton de suppression
                documentPreview.visibility = View.VISIBLE
                deleteDocumentButton.visibility = View.VISIBLE

                documentPreview.setImageURI(uri)

                // Configurer l'ouverture du document lors du clic sur l'aperçu
                documentPreview.setOnClickListener {
                    val intent = Intent(Intent.ACTION_VIEW).apply {
                        setDataAndType(uri, "image/*") // Ajustez le type MIME selon le type de fichier attendu
                        flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
                    }
                    startActivity(intent)
                }

                // Configurer la suppression du document
                deleteDocumentButton.setOnClickListener {
                    documentPreview.visibility = View.GONE
                    deleteDocumentButton.visibility = View.GONE
                    // Ajoutez ici toute autre logique de nettoyage nécessaire
                }
            }
        }
    }




    companion object {
        private const val PICK_FILE_REQUEST_CODE = 1
    }
}
