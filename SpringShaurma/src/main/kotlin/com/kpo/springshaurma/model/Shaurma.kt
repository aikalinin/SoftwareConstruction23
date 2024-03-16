package com.kpo.springshaurma.model

data class Shaurma(
     val comments: String = "",
     val ingredients: MutableList<Ingredient> = mutableListOf()
)
