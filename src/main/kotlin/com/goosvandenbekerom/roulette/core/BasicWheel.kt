package com.goosvandenbekerom.roulette.core

import java.util.*

class BasicWheel(gameId: Long) : IWheel {
    private val rng = Random(gameId)

    override fun spin() : Result {
        return Result(rng.nextInt(RANDOM_UPPER_BOUND))
    }
}