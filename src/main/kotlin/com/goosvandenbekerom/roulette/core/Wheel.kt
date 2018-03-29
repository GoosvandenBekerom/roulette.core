package com.goosvandenbekerom.roulette.core

import java.util.*

class Wheel(gameId: Long) {
    private val rng = Random(gameId)

    fun spin() : Result {
        return Result(rng.nextInt(RANDOM_UPPER_BOUND))
    }
}