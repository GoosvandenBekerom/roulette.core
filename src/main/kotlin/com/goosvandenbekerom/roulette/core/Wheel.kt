package com.goosvandenbekerom.roulette.core

import java.util.*

class Wheel(gameId: Long) {
    private val rng = Random(gameId)

    fun spin() : Result {
        val number = rng.nextInt(RANDOM_UPPER_BOUND)
        val color = RouletteColor.from(number)
        return Result(color, number, Date())
    }
}