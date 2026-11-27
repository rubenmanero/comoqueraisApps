package com.ruben.comoqueraisapps

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ruben.comoqueraisapps.BoardgamesApp.BoardgamesActivity
import com.ruben.comoqueraisapps.DotHunter.DotHunterActivity
import com.ruben.comoqueraisapps.EjercicioRepaso.ReviewActivity
import com.ruben.comoqueraisapps.HelloApp.MainActivity
import com.ruben.comoqueraisapps.IMCApp.IMCActivity
import com.ruben.comoqueraisapps.MessageApp.MessageActivity
import com.ruben.comoqueraisapps.SuperheroApp.SuperheroListActivity
import com.ruben.comoqueraisapps.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnHelloApp = findViewById<Button>(R.id.btnHelloApp)
        val btnMessageApp = findViewById<Button>(R.id.btnMessageApp)
        val btnIMCApp = findViewById<Button>(R.id.btnIMCApp)
        val btnBoardgamesApp = findViewById<Button>(R.id.btnBoardgamesApp)
        val btnSuperheroApp = findViewById<Button>(R.id.btnSuperheroApp)
        val btnReviewApp = findViewById<Button>(R.id.btnRepaso)
        val btnDotHunter = findViewById<Button>(R.id.btnDotHunter)

        btnHelloApp.setOnClickListener { navigateToHelloApp() }
        btnMessageApp.setOnClickListener { navigateToMessageApp() }
        btnIMCApp.setOnClickListener { navigateToIMCApp() }
        btnBoardgamesApp.setOnClickListener { navigateToBoardgamesApp() }
        btnSuperheroApp.setOnClickListener { navigateToSuperheroApp() }
        btnReviewApp.setOnClickListener { navigateToReviewApp() }
        btnDotHunter.setOnClickListener { navigateToDotHunter() }
    }

    private fun navigateToHelloApp() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
    private fun navigateToMessageApp() {
        val intent = Intent(this, MessageActivity::class.java)
        startActivity(intent)
    }
    private fun navigateToIMCApp() {
        val intent = Intent(this, IMCActivity::class.java)
        startActivity(intent)
    }
    private fun navigateToBoardgamesApp() {
        val intent = Intent(this, BoardgamesActivity::class.java)
        startActivity(intent)
    }
    private fun navigateToSuperheroApp() {
        val intent = Intent(this, SuperheroListActivity::class.java)
        startActivity(intent)
    }
    private fun navigateToReviewApp() {
        var intent = Intent(this, ReviewActivity::class.java)
        startActivity(intent)
    }
    private fun navigateToDotHunter() {
        var intent = Intent(this, DotHunterActivity::class.java)
        startActivity(intent)
    }

}