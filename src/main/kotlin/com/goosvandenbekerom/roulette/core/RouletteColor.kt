package com.goosvandenbekerom.roulette.core

import com.goosvandenbekerom.roulette.core.exception.NonExistingRouletteResult

enum class RouletteColor {
    RED, BLACK, GREEN;

    companion object {
        fun from(number: Int) : RouletteColor {
            if (number == ZERO || number == DOUBLE_ZERO) return GREEN
            if (number !in ZERO..MAX_NUMBER) throw NonExistingRouletteResult(number)
            return if (number in intArrayOf(1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36)) RED
            else BLACK
        }
    }
}
