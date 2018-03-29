package com.goosvandenbekerom.roulette.core

sealed class BetType(val multiplier: Int) {
    class Odd : BetType(ONE_TO_ONE_MULTIPLIER) {
        override fun isWin(result: Result) = result.number % 2 != 0
    }
    class Even : BetType(ONE_TO_ONE_MULTIPLIER) {
        override fun isWin(result: Result) = result.number % 2 == 0
    }
    class Red : BetType(ONE_TO_ONE_MULTIPLIER) {
        override fun isWin(result: Result) = result.color == RouletteColor.RED
    }
    class Black : BetType(ONE_TO_ONE_MULTIPLIER) {
        override fun isWin(result: Result) = result.color == RouletteColor.BLACK
    }
    class FirstHalf : BetType(ONE_TO_ONE_MULTIPLIER) {
        override fun isWin(result: Result) = result.number in 1..18
    }
    class SecondHalf : BetType(ONE_TO_ONE_MULTIPLIER) {
        override fun isWin(result: Result) = result.number in 19..36
    }
    class FirstDozen : BetType(ONE_TO_TWO_MULTIPLIER) {
        override fun isWin(result: Result) = result.number in 1..12
    }
    class SecondDozen : BetType(ONE_TO_TWO_MULTIPLIER){
        override fun isWin(result: Result) = result.number in 13..24
    }
    class ThirdDozen : BetType(ONE_TO_TWO_MULTIPLIER) {
        override fun isWin(result: Result) = result.number in 25..36
    }
    class FirstColumn : BetType(ONE_TO_TWO_MULTIPLIER) {
        override fun isWin(result: Result) = result.number in 1..34 step 3
    }
    class SecondColumn : BetType(ONE_TO_TWO_MULTIPLIER){
        override fun isWin(result: Result) = result.number in 2..35 step 3
    }
    class ThirdColumn : BetType(ONE_TO_TWO_MULTIPLIER) {
        override fun isWin(result: Result) = result.number in 3..36 step 3
    }
    class Number(val number: Int) : BetType(SINGLE_NUMBER_MULTIPLIER) {
        override fun isWin(result: Result) = result.number == number
    }
    class TwoNumber(vararg val numbers: Int) : BetType(TWO_NUMBER_MULTIPLIER) {
        override fun isWin(result: Result) = result.number in numbers.slice(0..1)
    }
    class ThreeNumber(vararg val numbers: Int) : BetType(THREE_NUMBER_MULTIPLIER) {
        override fun isWin(result: Result) = result.number in numbers.slice(0..2)
    }
    class FourNumber(vararg val numbers: Int) : BetType(FOUR_NUMBER_MULTIPLIER) {
        override fun isWin(result: Result) = result.number in numbers.slice(0..3)
    }
    class FiveNumber(vararg val numbers: Int) : BetType(FIVE_NUMBER_MULTIPLIER) {
        override fun isWin(result: Result) = result.number in numbers.slice(0..4)
    }
    class SixNumber(vararg val numbers: Int) : BetType(SIX_NUMBER_MULTIPLIER) {
        override fun isWin(result: Result) = result.number in numbers.slice(0..5)
    }

    abstract fun isWin(result: Result) : Boolean
}