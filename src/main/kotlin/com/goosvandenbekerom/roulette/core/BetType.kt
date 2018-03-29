package com.goosvandenbekerom.roulette.core

sealed class BetType(val multiplier: Int) {
    class Odd() : BetType(ONE_TO_ONE_MULTIPLIER)
    class Even() : BetType(ONE_TO_ONE_MULTIPLIER)
    class Red() : BetType(ONE_TO_ONE_MULTIPLIER)
    class Black() : BetType(ONE_TO_ONE_MULTIPLIER)
    class FirstHalf() : BetType(ONE_TO_ONE_MULTIPLIER)
    class SecondHalf() : BetType(ONE_TO_ONE_MULTIPLIER)
    class FirstDozen() : BetType(ONE_TO_TWO_MULTIPLIER)
    class SecondDozen() : BetType(ONE_TO_TWO_MULTIPLIER)
    class ThirdDozen() : BetType(ONE_TO_TWO_MULTIPLIER)
    class FirstColumn() : BetType(ONE_TO_TWO_MULTIPLIER)
    class SecondColumn() : BetType(ONE_TO_TWO_MULTIPLIER)
    class ThirdColumn() : BetType(ONE_TO_TWO_MULTIPLIER)
    class Number(val number: Int) : BetType(SINGLE_NUMBER_MULTIPLIER)
    class TwoNumber(vararg val numbers: Int) : BetType(TWO_NUMBER_MULTIPLIER)
    class ThreeNumber(vararg val numbers: Int) : BetType(THREE_NUMBER_MULTIPLIER)
    class FourNumber(vararg val numbers: Int) : BetType(FOUR_NUMBER_MULTIPLIER)
    class FiveNumber(vararg val numbers: Int) : BetType(FIVE_NUMBER_MULTIPLIER)
    class SixNumber(vararg val numbers: Int) : BetType(SIX_NUMBER_MULTIPLIER)
}