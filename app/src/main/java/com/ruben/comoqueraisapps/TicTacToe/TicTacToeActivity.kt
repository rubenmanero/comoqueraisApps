package com.ruben.comoqueraisapps.TicTacToe

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.setPadding
import com.ruben.comoqueraisapps.R

class TicTacToeActivity : AppCompatActivity() {
    private lateinit var tvPlayer: TextView
    private var views: MutableList<ImageView> = mutableListOf()
    private var positions: Array<Int> = arrayOf(
        R.id.im1,
        R.id.im2,
        R.id.im3,
        R.id.im4,
        R.id.im5,
        R.id.im6,
        R.id.im7,
        R.id.im8,
        R.id.im9
    )
    private var player1turn: Boolean = true
    private var player2turn: Boolean = false
    private var flag: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tic_tac_toe)

        initComponents(positions)
        initListeners()
        initUI()
    }

    private fun initComponents(ids: Array<Int>) {
        tvPlayer = findViewById(R.id.tvPlayer)
        for (i in ids.indices) {
            val imageView = findViewById<ImageView>(ids[i])
            views.add(imageView)
        }
    }

    private fun initListeners() {
        for (index in views.indices) {
            views[index].setOnClickListener { updateValues(index) }
        }
    }

    private fun updateValues(position: Int) {
        Log.i("pulsa", position.toString())
        if (positions[position] == 0 && player1turn) {
            positions[position] = 1
            flag++
            Log.i("actualiza", positions[position].toString())
            player1turn = !player1turn
            player2turn = !player2turn
            tvPlayer.text = "Player 2"
            tvPlayer.setTextColor(getColor(R.color.tictactoe_player2))
            uploadUI(position)
        }
        if (positions[position] == 0 && player2turn) {
            positions[position] = 2
            flag++
            Log.i("actualiza", positions[position].toString())
            player1turn = !player1turn
            player2turn = !player2turn
            tvPlayer.text = "Player 1"
            tvPlayer.setTextColor(getColor(R.color.tictactoe_player1))
            uploadUI(position)
        }
    }

    private fun uploadUI(i: Int) {
        if (positions[i] == 1) {
            views[i].setBackgroundColor(getColor(R.color.tictactoe_player1))
            views[i].setImageResource(R.drawable.ic_launcher_foreground)
            views[i].setPadding(0)
        }

        if (positions[i] == 2) {
            views[i].setBackgroundColor(getColor(R.color.tictactoe_player2))
            views[i].setImageResource(R.drawable.rounded_arrow)
            views[i].setPadding((18 * this.resources.displayMetrics.density).toInt())
        }

        for (i in 1..2) {
            checkGame(i)
        }
    }

    private fun checkGame(i: Int) {
        if ((positions[0] == i && positions[1] == i && positions[2] == i) ||
            (positions[3] == i && positions[4] == i && positions[5] == i) ||
            (positions[6] == i && positions[7] == i && positions[8] == i) ||
            (positions[0] == i && positions[3] == i && positions[6] == i) ||
            (positions[1] == i && positions[4] == i && positions[7] == i) ||
            (positions[2] == i && positions[5] == i && positions[8] == i) ||
            (positions[0] == i && positions[4] == i && positions[8] == i) ||
            (positions[2] == i && positions[4] == i && positions[6] == i)) {

            tvPlayer.text = "Player $i win!!"
            flag = 0
            if (i == 1) {
                tvPlayer.setTextColor(getColor(R.color.tictactoe_player1))
            } else {
                tvPlayer.setTextColor(getColor(R.color.tictactoe_player2))
            }

            Handler(Looper.getMainLooper()).postDelayed({
                initUI()
            }, 2000)
        }
        if (flag==9) {
            flag = 0
            tvPlayer.text = "It's a tie!!"
            tvPlayer.setTextColor(getColor(R.color.black))

            Handler(Looper.getMainLooper()).postDelayed({
                initUI()
            }, 2000)
        }
    }

    private fun initUI() {
        if(player1turn) {
            tvPlayer.text = "Player 1"
            tvPlayer.setTextColor(getColor(R.color.tictactoe_player1))
        } else {
            tvPlayer.text = "Player 2"
            tvPlayer.setTextColor(getColor(R.color.tictactoe_player2))
        }
        for (i in positions.indices) {
            positions[i] = 0
            Log.i("reseteo", positions[i].toString())
        }
        for (index in views.indices) {
            views[index].setBackgroundColor(getColor(R.color.tictactoe_background))
            views[index].setImageResource(0)
        }
    }
}