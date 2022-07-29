package com.example.pokedex

import java.io.Serializable

data class PokemonModel(
   val name:String,
   val number: String,
   val image:Int,
   val backgroundColor: String,
   val ability: String,
   val weight: String,
   val height: String,
   val moves: String,
   val descriptions: String,
   val hp: String,
   val attack: String,
   val def: String,
   val sdef: String,
   val satk: String,
   val spd: String
):Serializable
