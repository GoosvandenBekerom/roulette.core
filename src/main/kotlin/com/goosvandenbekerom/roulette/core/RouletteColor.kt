package com.goosvandenbekerom.roulette.core

enum class RouletteColor {
    RED, BLACK, GREEN;

    companion object {
        fun from(number: Int) : RouletteColor {
            if (number == ZERO || number == DOUBLE_ZERO) return GREEN
            return if (number in intArrayOf(1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36)) RED
            else BLACK
        }
    }
}
