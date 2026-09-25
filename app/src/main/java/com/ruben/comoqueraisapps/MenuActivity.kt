package com.ruben.comoqueraisapps

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ruben.comoqueraisapps.HelloApp.MainActivity
import com.ruben.comoqueraisapps.IMCApp.IMCActivity
import com.ruben.comoqueraisapps.MessageApp.MessageActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnHelloApp = findViewById<Button>(R.id.btnHelloApp)
        val btnMessageApp = findViewById<Button>(R.id.btnMessageApp)
        val btnIMCApp = findViewById<Button>(R.id.btnIMCApp)

        btnHelloApp.setOnClickListener { navigateToHelloApp() }
        btnMessageApp.setOnClickListener { navigateToMessageApp() }
        btnIMCApp.setOnClickListener { navigateToIMCApp() }
    }

    private fun navigateToHelloApp() {
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
    private fun navigateToMessageApp() {
        var intent = Intent(this, MessageActivity::class.java)
        startActivity(intent)
    }
    private fun navigateToIMCApp() {
        var intent = Intent(this, IMCActivity::class.java)
        startActivity(intent)
    }


}