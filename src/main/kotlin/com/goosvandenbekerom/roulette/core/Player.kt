package com.goosvandenbekerom.roulette.core

import com.goosvandenbekerom.roulette.core.exception.NotEnoughChipsException

data class Player(val name: String, val chipColor: String, private val initialChipAmount: Int = 0) {
    var chipAmount: Int = initialChipAmount
        private set

    fun removeChips(amount: Int) {
        if (amount > chipAmount) throw NotEnoughChipsException()
        chipAmount -= amount
    }

    fun addChips(amount: Int) {
        chipAmount += amount
    }
}