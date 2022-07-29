package com.example.pokedex

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.databinding.ItemPokemonBinding

class PokedexAdapter(var list: ArrayList<PokemonModel>, val itemClicker: ItemClicker) :
    RecyclerView.Adapter<PokedexAdapter.PokemonHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonHolder {
        return PokemonHolder(ItemPokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: PokemonHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class PokemonHolder(private var binding: ItemPokemonBinding) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(pokemonModel: PokemonModel) {

            itemView.setOnClickListener {
                itemClicker.itemClick(pokemonModel)
            }

            binding.numberTv.text = pokemonModel.number
            binding.pokemonImg.setImageResource(pokemonModel.image)
            binding.namePokemonTv.text = pokemonModel.name
            changeStrokeColor(binding.containerPokemons, pokemonModel.backgroundColor)
            changeSolidColor(binding.namePokemonTv, pokemonModel.backgroundColor)
            binding.numberTv.setTextColor(Color.parseColor(pokemonModel.backgroundColor))
        }
    }

    private fun changeStrokeColor(view: View, color: String) {
        val drawable: GradientDrawable = view.background as GradientDrawable
        drawable.mutate()
        drawable.setStroke(4, Color.parseColor(color))
    }

    private fun changeSolidColor(view :View, color: String) {
        val drawable: GradientDrawable = view.background as GradientDrawable
        drawable.mutate()
        drawable.setStroke(4, Color.parseColor(color))
        drawable.setColor(Color.parseColor(color))
    }
}