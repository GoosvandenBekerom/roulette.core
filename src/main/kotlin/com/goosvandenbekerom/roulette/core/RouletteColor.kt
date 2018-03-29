package com.goosvandenbekerom.roulette.core

enum class RouletteColor {
    RED, BLACK, GREEN, ANY;

    companion object {
        fun from(number: Int) : RouletteColor {
            if (number == ZERO || number == DOUBLE_ZERO) return GREEN
            return if (number % 2 == 0) BLACK
            else RED
        }
    }
}
