package com.kpo.springshaurma.converter

import com.kpo.springshaurma.model.Ingredient
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class IngredientToStringConverter : Converter<String, Ingredient> {
    private val ingredientMap: MutableMap<String, Ingredient> = HashMap()

    init {
        ingredientMap["CHEESE"] = Ingredient("CHEESE", "Сырный", Ingredient.Type.SAUCE)
        ingredientMap["SRSW"] = Ingredient("SRSW", "Кисло-сладкий", Ingredient.Type.SAUCE)
        ingredientMap["MAZIK"] = Ingredient("MAZIK", "Майонез", Ingredient.Type.SAUCE)
        ingredientMap["KTCHUNEZ"] = Ingredient("KTCHUNEZ", "100 Островов", Ingredient.Type.SAUCE)
        ingredientMap["WRAP_CHEESE"] = Ingredient("WRAP_CHEESE", "Сырный", Ingredient.Type.WRAP)
        ingredientMap["WRAP_DEFAULT"] = Ingredient("WRAP_DEFAULT", "Обычный", Ingredient.Type.WRAP)
    }

    override fun convert(id: String): Ingredient {
        return ingredientMap[id]!!
    }
}