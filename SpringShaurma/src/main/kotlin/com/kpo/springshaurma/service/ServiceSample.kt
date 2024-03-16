package com.kpo.springshaurma.service

import com.kpo.springshaurma.model.Ingredient
import org.springframework.stereotype.Service
import org.springframework.ui.Model
import java.util.*

interface ServiceSample {
    fun modifyModel(model: Model)
}

@Service
class ServiceSampleImpl : ServiceSample {
    override fun modifyModel(model: Model) {
        val ingredients = listOf(
                Ingredient("CHEESE", "Сырный", Ingredient.Type.SAUCE),
                Ingredient("SRSW", "Кисло-сладкий", Ingredient.Type.SAUCE),
                Ingredient("MAZIK", "Майонез", Ingredient.Type.SAUCE),
                Ingredient("KTCHUNEZ", "100 Островов", Ingredient.Type.SAUCE),
                Ingredient("WRAP_CHEESE", "Сырный", Ingredient.Type.WRAP),
                Ingredient("WRAP_DEFAULT", "Обычный", Ingredient.Type.WRAP)
        )

        val types = Ingredient.Type.entries.toTypedArray()
        for (type in types) {
            model.addAttribute(type.toString().lowercase(Locale.getDefault()), filterByType(ingredients, type))
        }
    }

    private fun filterByType(ingredients: List<Ingredient>, type: Ingredient.Type): List<Ingredient> {
        return ingredients
                .stream()
                .filter { x: Ingredient -> x.type == type }
                .toList()
    }
}