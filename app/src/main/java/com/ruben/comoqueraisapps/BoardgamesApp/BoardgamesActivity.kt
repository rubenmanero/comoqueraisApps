package com.ruben.comoqueraisapps.BoardgamesApp

import android.os.Bundle
import android.widget.Adapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ruben.comoqueraisapps.BoardgamesApp.GameCategory.*
import com.ruben.comoqueraisapps.R

class BoardgamesActivity : AppCompatActivity() {

    private val categories = listOf(Cooperative, Deckbuilding, Euro, LCG, Legacy)


    private val games = listOf (
        Game("Frostpunk", Cooperative),
        Game("Hero Realm", Deckbuilding),
        Game("Agricola", Euro),
        Game("Arkham Horror", LCG),
        Game("Gloomhaven", Legacy)
    )

    private lateinit var rvCategories: RecyclerView
    private lateinit var rvGames: RecyclerView
    private lateinit var categoriesAdapter: CategoriesAdapter
    private lateinit var gamesAdapter: GamesAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_boardgames)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initComponents()
        initUI()
    }

    private fun initUI() {
        categoriesAdapter = CategoriesAdapter(categories)
        rvCategories.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.HORIZONTAL,
            false)
        rvCategories.adapter = categoriesAdapter

        gamesAdapter = GamesAdapter(games)
        rvGames.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        rvGames.adapter = gamesAdapter

    }

    private fun initComponents() {
        rvCategories = findViewById(R.id.rvCategories)
        rvGames = findViewById(R.id.rvGames)
    }
}