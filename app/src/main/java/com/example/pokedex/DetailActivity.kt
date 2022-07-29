package com.example.pokedex

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.pokedex.databinding.ActivityDetailBinding
import com.example.pokedex.databinding.ActivityMainBinding
import com.google.android.material.progressindicator.LinearProgressIndicator

class DetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val model : PokemonModel = intent.getSerializableExtra("model") as PokemonModel
        binding.detailContainer.setBackgroundColor(Color.parseColor(model.backgroundColor))


    binding.tvNameDetail.text = model.name
    binding.ivPokemonImage.setImageResource(model.image)
    binding.tvNumberPokemon.text = model.number
    binding.tvAbility.text = model.ability
    changeSolidColor(binding.tvAbility, model.backgroundColor)
    binding.tvAbout.setTextColor(Color.parseColor(model.backgroundColor))
    binding.tvWeight.text = model.weight
    binding.tvNumberHeight.text = model.height
    binding.tvMovesPokemon.text = model.moves
    binding.tvDescription.text = model.descriptions
    binding.tvBaseStatic.setTextColor(Color.parseColor(model.backgroundColor))
    binding.tvNumberHp.text = model.hp
    binding.tvNumberAtk.text = model.attack
    binding.tvNumberDef.text = model.def
    binding.tvNumberSdef.text = model.sdef
    binding.tvNumberSatk.text = model.satk
    binding.tvNumberSpd.text = model.spd
    binding.tvHp.setTextColor(Color.parseColor(model.backgroundColor))
    binding.tvAtk.setTextColor(Color.parseColor(model.backgroundColor))
    binding.tvDef.setTextColor(Color.parseColor(model.backgroundColor))
    binding.tvSdef.setTextColor(Color.parseColor(model.backgroundColor))
    binding.tvSatk.setTextColor(Color.parseColor(model.backgroundColor))
    binding.tvSpd.setTextColor(Color.parseColor(model.backgroundColor))

    setColorProgressBar(binding.progressHp, model.backgroundColor, model.hp.toInt())
    setColorProgressBar(binding.progressAtk, model.backgroundColor, model.attack.toInt())
    setColorProgressBar(binding.progressDef, model.backgroundColor, model.def.toInt())
    setColorProgressBar(binding.progressSdef, model.backgroundColor, model.sdef.toInt())
    setColorProgressBar(binding.progressSatk, model.backgroundColor, model.satk.toInt())
    setColorProgressBar(binding.progressSpd, model.backgroundColor, model.spd.toInt())
}

private fun setColorProgressBar(progressBar: LinearProgressIndicator, color: String, progress: Int) {
    progressBar.setIndicatorColor(Color.parseColor(color))
    progressBar.progress = progress
}

private fun changeSolidColor(view: View, color: String) {
    val drawable: GradientDrawable = view.background as GradientDrawable
    drawable.mutate()
    drawable.setStroke(4, Color.parseColor(color))
    drawable.setColor(Color.parseColor(color))
    }
}
