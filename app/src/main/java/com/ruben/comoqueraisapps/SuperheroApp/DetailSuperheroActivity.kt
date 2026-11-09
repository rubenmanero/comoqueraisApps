package com.ruben.comoqueraisapps.SuperheroApp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import coil3.load
import com.ruben.comoqueraisapps.R
import com.ruben.comoqueraisapps.SuperheroApp.SuperheroListActivity.Companion.EXTRA_ID
import com.ruben.comoqueraisapps.databinding.ActivityDetailSuperheroBinding
import com.ruben.comoqueraisapps.databinding.ActivitySuperheroListBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DetailSuperheroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailSuperheroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailSuperheroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val id: String = intent.getStringExtra(EXTRA_ID).orEmpty()
        getSuperheroInformation(id)
    }

    private fun getSuperheroInformation(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = getRetrofit().create(ApiService::class.java)
                .getSuperheroDetail(id)
            if(response.body() != null) {
                runOnUiThread { createUI(response.body()!!) }
            }
        }
    }

    private fun createUI(superhero: SuperheroDetailResponse) {
        binding.ivSuperhero.load(superhero.image.url)
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/api/10229233666327556/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}