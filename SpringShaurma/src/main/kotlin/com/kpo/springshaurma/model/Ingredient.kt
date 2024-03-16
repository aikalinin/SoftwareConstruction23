package com.kpo.springshaurma.model;

data class Ingredient(
        val id: String,
        val name: String,
        val type: Type
) {

    enum class Type {
        SAUCE,
        WRAP
    }
}
