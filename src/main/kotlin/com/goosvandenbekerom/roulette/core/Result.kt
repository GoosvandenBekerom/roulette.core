package com.goosvandenbekerom.roulette.core

import java.util.Date

data class Result(val color: RouletteColor, val number: Int, val timestamp: Date){
    override fun toString() = "Result(color=$color, number=$number)"
}