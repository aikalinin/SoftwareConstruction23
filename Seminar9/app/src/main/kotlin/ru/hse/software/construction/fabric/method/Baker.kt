package ru.hse.software.construction.fabric.method

import ru.hse.software.construction.CookieKeys.CALORIES_PROPERTY_KEY
import ru.hse.software.construction.CookieKeys.WEIGHT_PROPERTY_KEY

fun interface Baker {
    fun createCookie(properties: Map<String, Any>): Cookie
}

/* Начало примера абстрактной фабрики */
interface FabricBaker {
    fun createCookie(properties: Map<String, Any>): Cookie

    fun createPie(): Pie
}

class Pie

class ChocolateFabricBaker: FabricBaker {

    override fun createCookie(properties: Map<String, Any>): Cookie {
        TODO("Not yet implemented")
    }

    override fun createPie(): Pie {
        TODO("Not yet implemented")
    }

}

/* Конец примера абстрактной фабрики */

class ChocolateCookieBaker : Baker {
    override fun createCookie(properties: Map<String, Any>): Cookie {
        val weight = properties[WEIGHT_PROPERTY_KEY] as Double
        val calories = properties[CALORIES_PROPERTY_KEY] as Double

        return ChocolateCookie(weight, listOf(), calories)
    }
}
