package com.ruben.comoqueraisapps.EjercicioRepaso

import android.app.Dialog
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ruben.comoqueraisapps.R
import com.ruben.comoqueraisapps.databinding.ActivityMainBinding
import com.ruben.comoqueraisapps.databinding.ActivityReviewBinding

class ReviewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityReviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityReviewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initListerners()

    }

    private fun initListerners() {
        binding.tv1.setOnClickListener { showDialog(binding.tv1) }
        binding.tv2.setOnClickListener { showDialog(binding.tv2) }
        binding.tv3.setOnClickListener { showDialog(binding.tv3) }
        binding.tv4.setOnClickListener { showDialog(binding.tv4) }
        binding.tv5.setOnClickListener { showDialog(binding.tv5) }
        binding.tv6.setOnClickListener { showDialog(binding.tv6) }
        binding.tv7.setOnClickListener { showDialog(binding.tv7) }
        binding.tv8.setOnClickListener { showDialog(binding.tv8) }
        binding.tv9.setOnClickListener { showDialog(binding.tv9) }
        binding.tv10.setOnClickListener { showDialog(binding.tv10) }
    }

    private fun showDialog(view: TextView) {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_review)
        dialog.show()
    }
}