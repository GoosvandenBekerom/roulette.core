package com.goosvandenbekerom.roulette.core.exception

class NonExistingRouletteResult(number: Int) : RouletteException("The given number $number is not a valid roulette result")