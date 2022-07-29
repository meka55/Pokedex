package com.example.pokedex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pokedex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ItemClicker{
    lateinit var binding:  ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initAdapter()
    }

    private fun initAdapter() {
        val list = arrayListOf<PokemonModel>()
        list.add(PokemonModel("Bulbasaur","001",R.drawable.bulbasaur,"#74CB48","Grass","6,9 kg", "0,7m", "Chlorophyll \nOvergrow", "There is a plant seed on its back right from the day this Pokémon is born. The seed slowly grows larger.", "045", "049", "049", "065", "065", "045"))
        list.add(PokemonModel("Butterfree","012",R.drawable.butterfree,"#A7B723","Flying","32,0 kg", "1,1 m", "Compound-Eyes \nTinted-Lines", "In battle, it flaps its wings at great speed to release highly toxic dust into the air.", "060", "045", "050", "090", "080", "070"))
        list.add(PokemonModel("Charmander","004",R.drawable.charmander,"#F57D31","Fire","8,5 kg", "0,6 m", "Mega-Punch \nFire-Punch","It has a preference for hot things. When it rains, steam is said to spout from the tip of its tail.","039","052", "043", "060", "050", "065"))
        list.add(PokemonModel("Ditto","132",R.drawable.ditto,"#AAA67F", "Normal", "4,0 kg", "0,3 m", "Limber \nImposter", "It can reconstitute its entire cellular structure to change into what it sees, but it returns to normal when it relaxes.", "048", "048", "048", "048", "048", "048" ))
        list.add(PokemonModel("Mew","152",R.drawable.mew,"#FB5584","Psychic","4,0 kg", "0,4 m", "Synchronize", "When viewed through a microscope, this Pokémon’s short, fine, delicate hair can be seen.", "100","100","100","100","100","100"))
        list.add(PokemonModel("Pikachu","025",R.drawable.pikachu,"#F9CF30", "Electric","6,0 kg", "0,4 m", "Mega-Punch \nPay-Day", "Pikachu that can generate powerful electricity have cheek sacs that are extra soft and super stretchy.", "035", "055", "040", "050", "050", "090"))
        list.add(PokemonModel("Squirtle","007",R.drawable.squirtle,"#6493EB","Water","9,0 kg", "0,5 m", "Torrent \nRain-Dish", "When it retracts its long neck into its shell, it squirts out water with vigorous force.", "044", "048", "065","050", "064", "043"))
        list.add(PokemonModel("Pineco","204",R.drawable.pineco,"#B7B9D0","Steel", "60,0 kg", "0,4 m", "Sturdy \nRock-Head", "It eats iron ore - and sometimes railroad tracks - to build up the steel armor that protects its body.", "050", "070", "100", "040", "040", "030"))
        list.add(PokemonModel("Gastly","092",R.drawable.gastly,"#70559B","Ghost", "0,1 kg", "1,3 m", "Levitate", "Born from gases, anyone would faint if engulfed by its gaseous body, which contains poison.","030", "035", "030", "100", "035", "080"))


        val pokemonAdapter = PokedexAdapter(list,this)
        binding.recyclerView.adapter = pokemonAdapter
    }

    override fun itemClick(model: PokemonModel) {
        val intent = Intent(this,DetailActivity::class.java)
        intent.putExtra("model",model)
        startActivity(intent)
    }
}