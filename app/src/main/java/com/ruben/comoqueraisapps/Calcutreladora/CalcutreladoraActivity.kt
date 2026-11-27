package com.ruben.comoqueraisapps.Calcutreladora

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ruben.comoqueraisapps.R
import com.ruben.comoqueraisapps.databinding.ActivityCalcutreladoraBinding

class CalcutreladoraActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCalcutreladoraBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCalcutreladoraBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnCalculate.setOnClickListener { navigateToResult() }
    }

    private fun navigateToResult() {
        val n1 = binding.etN1.text.toString()
        val n2 = binding.etN2.text.toString()
        val op = binding.rgOp.findViewById<RadioButton>(binding.rgOp.checkedRadioButtonId).text.toString()
        if (n1.isNotEmpty() && n2.isNotEmpty()) {
            val intent = Intent(this, CalcutreladoraResultActivity::class.java)
            intent.putExtra("n1", n1)
            intent.putExtra("n2", n2)
            intent.putExtra("op", op)
            startActivity(intent)
        }
    }
}