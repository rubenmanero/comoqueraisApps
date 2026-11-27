package com.ruben.comoqueraisapps.Memory

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ruben.comoqueraisapps.R
import com.ruben.comoqueraisapps.databinding.ActivityMemoryBinding

class MemoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMemoryBinding
    private lateinit var cards: List<ImageView>

    private var sets = mutableListOf(1, 2, 3, 4, 3, 5, 6, 1, 4, 6, 5, 2)
    private var hits = 0
    private var turn = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMemoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initUI()
        Handler(Looper.getMainLooper()).postDelayed({ resetUI() }, 2000)

    }

    private fun initUI() {
        cards = listOf(
            binding.iv00,
            binding.iv01,
            binding.iv02,
            binding.iv10,
            binding.iv11,
            binding.iv12,
            binding.iv20,
            binding.iv21,
            binding.iv22,
            binding.iv30,
            binding.iv31,
            binding.iv32
        )

        cards.forEachIndexed { i, card ->
            card.setOnClickListener { changeCard(i) }
        }
    }

    fun changeCard(i: Int) {
        if (sets[i] != 0) {
            sets[i] = 0
            when (i) {
                0, 7 -> {
                    cards[i].setBackgroundColor(getColor(R.color.memory_card1))
                    cards[i].setImageDrawable(AppCompatResources.getDrawable(this,R.drawable.ic_substract))
                }

                1, 11 -> {
                    cards[i].setBackgroundColor(getColor(R.color.memory_card2))
                    cards[i].setImageDrawable(AppCompatResources.getDrawable(this,R.drawable.ic_add))
                }

                2, 4 -> {
                    cards[i].setBackgroundColor(getColor(R.color.memory_card3))
                    cards[i].setImageDrawable(AppCompatResources.getDrawable(this,R.drawable.ic_female))
                }

                3, 8 -> {
                    cards[i].setBackgroundColor(getColor(R.color.memory_card4))
                    cards[i].setImageDrawable(AppCompatResources.getDrawable(this,R.drawable.ic_launcher_foreground))
                }

                5, 10 -> {
                    cards[i].setBackgroundColor(getColor(R.color.memory_card5))
                    cards[i].setImageDrawable(AppCompatResources.getDrawable(this,R.drawable.rounded_arrow))
                }

                6, 9 -> {
                    cards[i].setBackgroundColor(getColor(R.color.memory_card6))
                    cards[i].setImageDrawable(AppCompatResources.getDrawable(this,R.drawable.ic_male))
                }
            }

            if (turn % 2 == 0) {
                checkPair(i)
            }
            turn++
            checkWin()
        }
    }

    private fun checkPair(i: Int) {
        when (i) {
            0 -> {
                if (sets[7] != 0) finishGame()
                else hits++
            }

            1 -> {
                if (sets[11] != 0) finishGame()
                else hits++
            }

            2 -> {
                if (sets[4] != 0) finishGame()
                else hits++
            }

            3 -> {
                if (sets[8] != 0) finishGame()
                else hits++
            }

            4 -> {
                if (sets[2] != 0) finishGame()
                else hits++
            }

            5 -> {
                if (sets[10] != 0) finishGame()
                else hits++
            }

            6 -> {
                if (sets[9] != 0) finishGame()
                else hits++
            }

            7 -> {
                if (sets[0] != 0) finishGame()
                else hits++
            }

            8 -> {
                if (sets[3] != 0) finishGame()
                else hits++
            }

            9 -> {
                if (sets[6] != 0) finishGame()
                else hits++
            }

            10 -> {
                if (sets[5] != 0) finishGame()
                else hits++
            }

            11 -> {
                if (sets[1] != 0) finishGame()
                else hits++
            }
        }
    }

    private fun finishGame() {
        when(hits) {
            0,1 -> binding.tvScore.text = "$hits hits :("
            2,3 -> binding.tvScore.text = "$hits hits :|"
            4 -> binding.tvScore.text = "$hits hits :)"
        }
        cards.forEach{ card ->
            card.isClickable = false
        }
        Handler(Looper.getMainLooper()).postDelayed({ resetUI() }, 2000)
    }


    private fun checkWin() {
        if (hits == 6) {
            binding.tvScore.text = "Victory!"
            cards.forEach { card ->
                card.isClickable = false
            }
            Handler(Looper.getMainLooper()).postDelayed({ resetUI() }, 2000)
        }
    }

    private fun resetUI() {
        cards.forEach { card ->
            card.setBackgroundColor(getColor(R.color.memory_background))
            card.setImageDrawable(null)
        }
        cards.forEach { card ->
            card.isClickable = true
        }
        sets = mutableListOf(1, 2, 3, 4, 3, 5, 6, 1, 4, 6, 5, 2)
        binding.tvScore.text = ""
        hits = 0
        turn = 1
    }
}