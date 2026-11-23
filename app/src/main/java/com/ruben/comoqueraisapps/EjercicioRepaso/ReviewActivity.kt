package com.ruben.comoqueraisapps.EjercicioRepaso

import android.app.Dialog
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
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

        val rgColors = dialog.findViewById<RadioGroup>(R.id.rgColors)
        val btnAplyColor = dialog.findViewById<CardView>(R.id.cvSelectColor)

        btnAplyColor.setOnClickListener {
            val colorSelected = rgColors.findViewById<RadioButton>(rgColors.checkedRadioButtonId)
            when (colorSelected.text) {
                getString(R.string.white) -> {
                    view.setBackgroundColor(getColor(R.color.white))
                    view.setText(R.string.white)
                    view.setTextColor(getColor(R.color.black))
                }
                getString(R.string.red) -> {
                    view.setBackgroundColor(getColor(R.color.red))
                    view.setText(R.string.red)
                    view.setTextColor(getColor(R.color.white))
                }
                getString(R.string.white) -> {
                    view.setBackgroundColor(getColor(R.color.white))
                    view.setText(R.string.white)
                    view.setTextColor(getColor(R.color.black))
                }
                getString(R.string.orange) -> {
                    view.setBackgroundColor(getColor(R.color.orange))
                    view.setText(R.string.orange)
                    view.setTextColor(getColor(R.color.black))
                }
                getString(R.string.yellow) -> {
                    view.setBackgroundColor(getColor(R.color.yellow))
                    view.setText(R.string.yellow)
                    view.setTextColor(getColor(R.color.black))
                }
                getString(R.string.green) -> {
                    view.setBackgroundColor(getColor(R.color.green))
                    view.setText(R.string.green)
                    view.setTextColor(getColor(R.color.black))
                }
                getString(R.string.cyan) -> {
                    view.setBackgroundColor(getColor(R.color.cyan))
                    view.setText(R.string.cyan)
                    view.setTextColor(getColor(R.color.black))
                }
                getString(R.string.blue) -> {
                    view.setBackgroundColor(getColor(R.color.blue))
                    view.setText(R.string.blue)
                    view.setTextColor(getColor(R.color.white))
                }
                getString(R.string.white) -> {
                    view.setBackgroundColor(getColor(R.color.white))
                    view.setText(R.string.white)
                    view.setTextColor(getColor(R.color.black))
                }
                getString(R.string.violet) -> {
                    view.setBackgroundColor(getColor(R.color.violet))
                    view.setText(R.string.violet)
                    view.setTextColor(getColor(R.color.white))
                }
                getString(R.string.gray) -> {
                    view.setBackgroundColor(getColor(R.color.gray))
                    view.setText(R.string.gray)
                    view.setTextColor(getColor(R.color.white))
                }
                getString(R.string.black) -> {
                    view.setBackgroundColor(getColor(R.color.black))
                    view.setText(R.string.black)
                    view.setTextColor(getColor(R.color.white))
                }
            }
            dialog.hide()
        }

        dialog.show()
    }
}