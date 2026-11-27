package com.ruben.comoqueraisapps.DotHunter

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ruben.comoqueraisapps.R
import com.ruben.comoqueraisapps.databinding.ActivityDotHunterBinding
import java.lang.Math.random

class DotHunterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDotHunterBinding

    private lateinit var tilesOut: List<List<CardView>>
    private lateinit var tilesIn: List<List<CardView>>
    private var hunterX = 0
    private var hunterY = 0
    private var preyX = 0
    private var preyY = 0
    private var obstacleX = 0
    private var obstacleY = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDotHunterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initComponents()
        initUI()
    }

    private fun initUI() {
        binding.tvMessage1.text = getString(R.string.initial_message1)
        binding.tvMessage1.setTextColor(getColor(R.color.white))
        binding.tvMessage2.text = getString(R.string.initial_message2)

        score = 0

        eraseItem(hunterX, hunterY)
        eraseItem(preyX, preyY)
        eraseItem(obstacleX, obstacleY)

        hunterX = 0
        hunterY = 0
        paintItem('h', hunterX, hunterY)

        preyX = (1..2).random()
        preyY = (1..4).random()
        paintItem('p', preyX, preyY)

        do {
            obstacleX = (0..2).random()
            obstacleY = (0..4).random()
        } while ((obstacleX == hunterX && obstacleY == hunterY) || (obstacleX == preyX && obstacleY == preyY))
        paintItem('o', obstacleX, obstacleY)

        Log.i("hunter", "x: $hunterY, y: $hunterX")
        Log.i("prey", "x: $preyY, y: $preyX")
        Log.i("obstacle", "x: $obstacleY, y: $obstacleX")

        Handler(Looper.getMainLooper()).postDelayed({
            binding.tvMessage1.text = "Don´t crash with green circles!"
            binding.tvMessage2.text = "Score: 0"
        }, 4000)

        binding.btnUp.isClickable = true
        binding.btnDown.isClickable = true
        binding.btnLeft.isClickable = true
        binding.btnRight.isClickable = true
    }

    private fun paintItem(item: Char, x: Int, y: Int) {
        when (item) {
            'h' -> {
                tilesOut[y][x].setCardBackgroundColor(getColor(R.color.dothunter_background))
                tilesIn[y][x].setCardBackgroundColor(getColor(R.color.white))
            }

            'p' -> {
                tilesOut[y][x].setCardBackgroundColor(getColor(R.color.dot_hunter_board))
                tilesIn[y][x].setCardBackgroundColor(getColor(R.color.black))
            }

            'o' -> {
                tilesOut[y][x].setCardBackgroundColor(getColor(R.color.green_out))
                tilesIn[y][x].setCardBackgroundColor(getColor(R.color.green_in))
            }
        }
    }

    private fun eraseItem(x: Int, y: Int) {
        tilesOut[y][x].setCardBackgroundColor(getColor(R.color.dot_hunter_tiles))
        tilesIn[y][x].setCardBackgroundColor(getColor(R.color.dot_hunter_tiles))
    }

    private fun initComponents() {
        tilesIn = listOf(
            listOf(binding.in00, binding.in01, binding.in02),
            listOf(binding.in10, binding.in11, binding.in12),
            listOf(binding.in20, binding.in21, binding.in22),
            listOf(binding.in30, binding.in31, binding.in32),
            listOf(binding.in40, binding.in41, binding.in42)
        )

        tilesOut = listOf(
            listOf(binding.out00, binding.out01, binding.out02),
            listOf(binding.out10, binding.out11, binding.out12),
            listOf(binding.out20, binding.out21, binding.out22),
            listOf(binding.out30, binding.out31, binding.out32),
            listOf(binding.out40, binding.out41, binding.out42)
        )

        binding.btnUp.setOnClickListener {
            moveUp()
            Log.i("hunter", "x: $hunterY, y: $hunterX")
            Log.i("prey", "x: $preyY, y: $preyX")
            Log.i("obstacle", "x: $obstacleY, y: $obstacleX")
        }
        binding.btnDown.setOnClickListener {
            moveDown()
            Log.i("hunter", "x: $hunterY, y: $hunterX")
            Log.i("prey", "x: $preyY, y: $preyX")
            Log.i("obstacle", "x: $obstacleY, y: $obstacleX")
        }
        binding.btnLeft.setOnClickListener {
            moveLeft()
            Log.i("hunter", "x: $hunterY, y: $hunterX")
            Log.i("prey", "x: $preyY, y: $preyX")
            Log.i("obstacle", "x: $obstacleY, y: $obstacleX")
        }
        binding.btnRight.setOnClickListener {
            moveRight()
            Log.i("hunter", "x: $hunterY, y: $hunterX")
            Log.i("prey", "x: $preyY, y: $preyX")
            Log.i("obstacle", "x: $obstacleY, y: $obstacleX")
        }
    }

    private fun moveUp() {
        if (hunterY != 0) {
            eraseItem(hunterX, hunterY)
            hunterY--
            paintItem('h', hunterX, hunterY)
            checkPosition()
        }
    }

    private fun moveDown() {
        if (hunterY != 4) {
            eraseItem(hunterX, hunterY)
            hunterY++
            paintItem('h', hunterX, hunterY)
            checkPosition()
        }
    }

    private fun moveLeft() {
        if (hunterX != 0) {
            eraseItem(hunterX, hunterY)
            hunterX--
            paintItem('h', hunterX, hunterY)
            checkPosition()
        }
    }

    private fun moveRight() {
        if (hunterX != 2) {
            eraseItem(hunterX, hunterY)
            hunterX++
            paintItem('h', hunterX, hunterY)
            checkPosition()
        }
    }

    private fun checkPosition() {
        if(obstacleX == hunterX && obstacleY == hunterY) gameOver()
        if(preyX == hunterX && preyY == hunterY) preyHunted()
    }

    private fun gameOver() {
        binding.tvMessage1.text = "You lose!"
        binding.tvMessage1.setTextColor(getColor(R.color.red))
        binding.tvMessage2.text = "You crashed! Score: $score"

        binding.btnUp.isClickable = false
        binding.btnDown.isClickable = false
        binding.btnLeft.isClickable = false
        binding.btnRight.isClickable = false

        Handler(Looper.getMainLooper()).postDelayed({ initUI() }, 3000)
    }

    private fun preyHunted() {
        score++
        eraseItem(obstacleX, obstacleY)
        binding.tvMessage2.text = "Score: $score"
        do {
            preyX = (0..2).random()
            preyY = (0..4).random()
        } while ((preyX == hunterX && preyY == hunterY))
        paintItem('p', preyX, preyY)
        do {
            obstacleX = (0..2).random()
            obstacleY = (0..4).random()
        } while ((obstacleX == hunterX && obstacleY == hunterY) || (obstacleX == preyX && obstacleY == preyY))
        paintItem('o', obstacleX, obstacleY)
        checkWin()
    }

    private fun checkWin() {
        if(score==10) {
            binding.tvMessage1.text = "You win!"
            binding.tvMessage1.setTextColor(getColor(R.color.green_out))
            binding.tvMessage2.text = "You reached 10 points\nCongratulations!"
            Handler(Looper.getMainLooper()).postDelayed({ initUI() }, 3000)

            binding.btnUp.isClickable = false
            binding.btnDown.isClickable = false
            binding.btnLeft.isClickable = false
            binding.btnRight.isClickable = false
        }
    }
}