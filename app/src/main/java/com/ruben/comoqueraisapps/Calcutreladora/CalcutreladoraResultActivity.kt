package com.ruben.comoqueraisapps.Calcutreladora

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ruben.comoqueraisapps.R
import com.ruben.comoqueraisapps.databinding.ActivityCalcutreladoraResultBinding

class CalcutreladoraResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCalcutreladoraResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCalcutreladoraResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val n1 = intent.getStringExtra("n1").orEmpty()
        val n2 = intent.getStringExtra("n2").orEmpty()
        val op = intent.getStringExtra("op").orEmpty()
        when (op) {
            "+" -> {
                binding.tvOperacion.text = "$n1 + $n2"
                binding.tvResult.text = (n1.toInt() + n2.toInt()).toString()
            }
            "-" -> {
                binding.tvOperacion.text = "$n1 - $n2"
                binding.tvResult.text = (n1.toInt() - n2.toInt()).toString()
            }
            "x" -> {
                binding.tvOperacion.text = "$n1 x $n2"
                binding.tvResult.text = (n1.toInt() * n2.toInt()).toString()
            }
            "/" -> {
                binding.tvOperacion.text = "$n1 / $n2"
                binding.tvResult.text = (n1.toInt() / n2.toInt()).toString()
            }
            "%" -> {
                binding.tvOperacion.text = "$n1 % $n2"
                binding.tvResult.text = (n1.toInt() % n2.toInt()).toString()
            }
            else -> {
                binding.tvOperacion.text = "Operación no válida"
                binding.tvResult.text = "#"
            }
        }
        binding.btnNew.setOnClickListener { onBackPressedDispatcher.onBackPressed() }
    }
}