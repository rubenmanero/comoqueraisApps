package com.ruben.comoqueraisapps.SuperheroApp

import android.os.Bundle
import android.util.TypedValue
import android.view.View
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
import kotlin.math.roundToInt

class DetailSuperheroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailSuperheroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailSuperheroBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
        binding.tvSuperheroName.text = superhero.name
        binding.tvSuperheroRealName.text = superhero.biography.fullName
        binding.tvPublisher.text = superhero.biography.publisher
        prepareStats(superhero.powerstats)

        val nombre = superhero.name
        val raza = superhero.appearance.race
        val lugar = superhero.biography.birthPlace
        val altura = superhero.appearance.height[1]
        val peso = superhero.appearance.weight[1]
        val alterEgos = superhero.biography.alteregos
        val aliases = superhero.biography.aliases
        val aparicion = superhero.biography.firstAppearance

        var texto = ""

        if (raza != "null") {
            texto += "$nombre es de la raza de los $raza. "
        } else {
            texto += "No se conoce la raza de $nombre. "
        }

        if (lugar != "null" && lugar != "-") {
            texto += "Nació en $lugar. "
        } else {
            texto += "Se desconoce su lugar de nacimiento. "
        }

        if (altura != "null" && peso != "null" && altura != "0 cm" && peso != "0 kg") {
            texto += "Mide $altura y pesa $peso."
        } else if (altura != "null" && altura != "0 cm") {
            texto += "Mide $altura."
        } else if (peso != "null" && peso != "0 kg") {
            texto += "Pesa $peso."
        }

        if (alterEgos != "No alter egos found.") {
            texto += "\n\nA veces adopta la identidad $alterEgos."
        } else {
            texto += "\n\nNo se le conocen alter egos."
        }

        if (aliases[0] != "-") {
            texto += "\n\nTambién se le conoce como "
            aliases.forEachIndexed { i, alias ->
                if (aliases.size == 1) {
                    texto += alias + "."
                } else {
                    when (i) {
                        aliases.size - 1 -> texto += "y " + alias + "."
                        aliases.size - 2 -> texto += alias + " "
                        else -> texto += alias + ", "
                    }
                }
            }
        }

        if (aparicion != "null" && aparicion != "-") {
            texto += "\n\nSu primera aparición fue en $aparicion."
        } else {
            texto += "\n\nSe desconoce cuándo apareció por primera vez."
        }

        binding.tvDescription.text = texto
    }

    private fun prepareStats(powerstats: PowerStatsResponse) {
        updateHeight(binding.viewIntelligence, powerstats.intelligence)
        updateHeight(binding.viewStrength, powerstats.strength)
        updateHeight(binding.viewSpeed, powerstats.speed)
        updateHeight(binding.viewDurability, powerstats.durability)
        updateHeight(binding.viewPower, powerstats.power)
        updateHeight(binding.viewCombat, powerstats.combat)
    }

    private fun updateHeight(view: View, stat: String) {
        val params = view.layoutParams
        if(stat != "null") {
            params.height = pxToDp(stat.toFloat())
        } else {
            params.height = 0
        }
        view.layoutParams = params
    }

    private fun pxToDp(px:Float):Int{
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
            px, resources.displayMetrics).roundToInt()
    }


    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/api/10229233666327556/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}