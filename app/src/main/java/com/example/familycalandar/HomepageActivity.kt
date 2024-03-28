package com.example.familycalandar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.gson.Gson

class HomepageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)
        val sharedPreferences = getSharedPreferences("UserDetails", MODE_PRIVATE)
        val loggedUserName = intent.getStringExtra("LoggedUser")
            ?: sharedPreferences.getString("LoggedUser", null)

        if (loggedUserName == null) {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
            return
        }

        val userJson = sharedPreferences.getString(loggedUserName, null)
        var savedUserType: String? = null
        userJson?.let {
            val userDetails = Gson().fromJson(it, Map::class.java)
            savedUserType = userDetails["typeUtilisateur"] as String?
        }
        val buttonDisconnect: Button = findViewById(R.id.buttonDisconnect)
        buttonDisconnect.setOnClickListener {
            sharedPreferences.edit().putBoolean("IsLoggedIn", false).apply()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        val buttonMainBoard: Button = findViewById(R.id.buttonMainboard)
        buttonMainBoard.setOnClickListener {
            when (savedUserType) {
                "Quotidien" -> startActivity(Intent(this, MainboardUserGeneralActivity::class.java))
                "Associatif" -> startActivity(Intent(this, MainboardAssociationActivity::class.java))
                "Voyage" -> startActivity(Intent(this, MainboardVoyageurActivity::class.java))
                "Etudes" -> startActivity(Intent(this, MainboardEtudiantActivity::class.java))
                "Famille" -> startActivity(Intent(this, MainboardParentsActivity::class.java))


            }
        }
    }
}