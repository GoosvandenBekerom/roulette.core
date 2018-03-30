package com.goosvandenbekerom.roulette.core

import java.util.Date

data class Result(val number: Int, val color: RouletteColor = RouletteColor.from(number), val timestamp: Date = Date())