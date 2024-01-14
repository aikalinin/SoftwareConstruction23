package ru.hse.software.construction.fabric.method

abstract class Cookie(
    val weight: Double,
    val ingredient: List<String>,
    val calories: Double
)

class ChocolateCookie(weight: Double, ingredient: List<String>, calories: Double) :
    Cookie(weight, ingredient, calories)

class CoconutCookie(weight: Double, ingredient: List<String>, calories: Double) : Cookie(weight, ingredient, calories)