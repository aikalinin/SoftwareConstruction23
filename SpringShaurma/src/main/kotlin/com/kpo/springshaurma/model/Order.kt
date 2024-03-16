package com.kpo.springshaurma.model

data class Order(
        val shaurmaList: MutableList<Shaurma> = ArrayList()
) {

    fun addShaurma(shaurma: Shaurma) {
        shaurmaList.add(shaurma)
    }
}