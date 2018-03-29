package com.goosvandenbekerom.roulette.core.exception

class AmountToLowException(amount: Int, minimum: Int)
    : RouletteException("Your bet amount of $amount is too low, game has a minimum of $minimum")