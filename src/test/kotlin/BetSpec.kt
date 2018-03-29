import com.goosvandenbekerom.roulette.core.*
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.context
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.junit.jupiter.api.Assertions.*

class BetSpec : Spek({
    val owner = Player("a", "b", 1000)
    given("a bet") {
        on("odd") {
            val bet = Bet(owner, 5, BetType.Odd())
            val winResult = 11
            val loseResult = 12
            it("should be a win when the result is $winResult") {
                assertTrue(bet.type.isWin(Result(winResult)))
            }
            it("Should be a loss when the result is $loseResult") {
                assertFalse(bet.type.isWin(Result(loseResult)))
            }
        }
        on("even") {
            val bet = Bet(owner, 5, BetType.Even())
            val winResult = 22
            val loseResult = 17
            it("Should be a win when the result is $winResult") {
                assertTrue(bet.type.isWin(Result(winResult)))
            }
            it("should be a loss when the result is $loseResult") {
                assertFalse(bet.type.isWin(Result(loseResult)))
            }
        }
        on("red") {
            val bet = Bet(owner, 5, BetType.Red())
            val winResult = 16
            val winResult2 = 19
            val loseResult = 2
            val loseResult2 = 13
            it("Should be a win when the result is $winResult") {
                assertTrue(bet.type.isWin(Result(winResult)))
            }
            it("Should be a win when the result is $winResult2") {
                assertTrue(bet.type.isWin(Result(winResult2)))
            }
            it("should be a loss when the result is $loseResult") {
                assertFalse(bet.type.isWin(Result(loseResult)))
            }
            it("should be a loss when the result is $loseResult2") {
                assertFalse(bet.type.isWin(Result(loseResult2)))
            }
        }
        on("black") {
            val bet = Bet(owner, 5, BetType.Black())
            val winResult = 11
            val winResult2 = 8
            val loseResult = 23
            val loseResult2 = 21
            it("Should be a win when the result is $winResult") {
                assertTrue(bet.type.isWin(Result(winResult)))
            }
            it("Should be a win when the result is $winResult2") {
                assertTrue(bet.type.isWin(Result(winResult2)))
            }
            it("should be a loss when the result is $loseResult") {
                assertFalse(bet.type.isWin(Result(loseResult)))
            }
            it("should be a loss when the result is $loseResult2") {
                assertFalse(bet.type.isWin(Result(loseResult)))
            }
        }
        on("first half") {
            val bet = Bet(owner, 5, BetType.FirstHalf())
            val winResult = 9
            val loseResult = 32
            it("Should be a win when the result is $winResult") {
                assertTrue(bet.type.isWin(Result(winResult)))
            }
            it("should be a loss when the result is $loseResult") {
                assertFalse(bet.type.isWin(Result(loseResult)))
            }
        }
        on("second half") {
            val bet = Bet(owner, 5, BetType.SecondHalf())
            val winResult = 25
            val loseResult = 5
            it("Should be a win when the result is $winResult") {
                assertTrue(bet.type.isWin(Result(winResult)))
            }
            it("should be a loss when the result is $loseResult") {
                assertFalse(bet.type.isWin(Result(loseResult)))
            }
        }
        on("first dozen") {
            val bet = Bet(owner, 5, BetType.FirstDozen())
            val winResult = 12
            val loseResult = 13
            it("Should be a win when the result is $winResult") {
                assertTrue(bet.type.isWin(Result(winResult)))
            }
            it("should be a loss when the result is $loseResult") {
                assertFalse(bet.type.isWin(Result(loseResult)))
            }
        }
        on("second dozen") {
            val bet = Bet(owner, 5, BetType.SecondDozen())
            val winResult = 16
            val loseResult = 12
            val loseResult2 = 25
            it("Should be a win when the result is $winResult") {
                assertTrue(bet.type.isWin(Result(winResult)))
            }
            it("should be a loss when the result is $loseResult") {
                assertFalse(bet.type.isWin(Result(loseResult)))
            }
            it("should be a loss when the result is $loseResult2") {
                assertFalse(bet.type.isWin(Result(loseResult2)))
            }
        }
        on("third dozen") {
            val bet = Bet(owner, 5, BetType.ThirdDozen())
            val winResult = 36
            val loseResult = 24
            it("Should be a win when the result is $winResult") {
                assertTrue(bet.type.isWin(Result(winResult)))
            }
            it("should be a loss when the result is $loseResult") {
                assertFalse(bet.type.isWin(Result(loseResult)))
            }
        }
        on("first column") {
            val bet = Bet(owner, 5, BetType.FirstColumn())
            val winResult = 16
            val loseResult = 21
            it("Should be a win when the result is $winResult") {
                assertTrue(bet.type.isWin(Result(winResult)))
            }
            it("should be a loss when the result is $loseResult") {
                assertFalse(bet.type.isWin(Result(loseResult)))
            }
        }
        on("second column") {
            val bet = Bet(owner, 5, BetType.SecondColumn())
            val winResult = 29
            val loseResult = 28
            val loseResult2 = 6
            it("Should be a win when the result is $winResult") {
                assertTrue(bet.type.isWin(Result(winResult)))
            }
            it("should be a loss when the result is $loseResult") {
                assertFalse(bet.type.isWin(Result(loseResult)))
            }
            it("should be a loss when the result is $loseResult2") {
                assertFalse(bet.type.isWin(Result(loseResult2)))
            }
        }
        on("third column") {
            val bet = Bet(owner, 5, BetType.ThirdColumn())
            val winResult = 18
            val loseResult = 7
            it("Should be a win when the result is $winResult") {
                assertTrue(bet.type.isWin(Result(winResult)))
            }
            it("should be a loss when the result is $loseResult") {
                assertFalse(bet.type.isWin(Result(loseResult)))
            }
        }
        on("number 14") {
            val winResult = 14
            val loseResult = 19
            val bet = Bet(owner, 5, BetType.Number(winResult))
            it("Should be a win when the result is $winResult") {
                assertTrue(bet.type.isWin(Result(winResult)))
            }
            it("should be a red result") {
                assertEquals(RouletteColor.RED, Result(winResult).color)
            }
            it("should be a loss when the result is $loseResult") {
                assertFalse(bet.type.isWin(Result(loseResult)))
            }
        }
        on("number 35") {
            val winResult = 35
            val loseResult = 19
            val bet = Bet(owner, 5, BetType.Number(winResult))
            it("Should be a win when the result is $winResult") {
                assertTrue(bet.type.isWin(Result(winResult)))
            }
            it("should be a black result") {
                assertEquals(RouletteColor.BLACK, Result(winResult).color)
            }
            it("should be a loss when the result is $loseResult") {
                assertFalse(bet.type.isWin(Result(loseResult)))
            }
        }
        on("line between 16 and 17") {
            val winResult = 16
            val winResult2 = 17
            val loseResult = 20
            val bet = Bet(owner, 5, BetType.TwoNumber(winResult, winResult2))
            it("Should be a win when the result is $winResult") {
                assertTrue(bet.type.isWin(Result(winResult)))
            }
            it("Should be a win when the result is $winResult2") {
                assertTrue(bet.type.isWin(Result(winResult)))
            }
            it("should be a loss when the result is $loseResult") {
                assertFalse(bet.type.isWin(Result(loseResult)))
            }
        }
        on("street of 10") {
            val winResult = 11
            val winResult2 = 12
            val loseResult = 20
            val bet = Bet(owner, 5, BetType.ThreeNumber(10, winResult, winResult2))
            it("Should be a win when the result is $winResult") {
                assertTrue(bet.type.isWin(Result(winResult)))
            }
            it("Should be a win when the result is $winResult2") {
                assertTrue(bet.type.isWin(Result(winResult)))
            }
            it("should be a loss when the result is $loseResult") {
                assertFalse(bet.type.isWin(Result(loseResult)))
            }
        }
        on("corner between 5, 6, 8, 9") {
            val winResult = 6
            val winResult2 = 8
            val loseResult = 7
            val bet = Bet(owner, 5, BetType.FourNumber(5, winResult, winResult2, 9))
            it("Should be a win when the result is $winResult") {
                assertTrue(bet.type.isWin(Result(winResult)))
            }
            it("Should be a win when the result is $winResult2") {
                assertTrue(bet.type.isWin(Result(winResult)))
            }
            it("should be a loss when the result is $loseResult") {
                assertFalse(bet.type.isWin(Result(loseResult)))
            }
        }
        on("streets of 0 and 1") {
            val winResult = DOUBLE_ZERO
            val winResult2 = 3
            val loseResult = 7
            val bet = Bet(owner, 5, BetType.FiveNumber(ZERO, DOUBLE_ZERO, 1, 2, winResult2))
            it("Should be a win when the result is $winResult") {
                assertTrue(bet.type.isWin(Result(winResult)))
            }
            it("Should be a win when the result is $winResult2") {
                assertTrue(bet.type.isWin(Result(winResult)))
            }
            it("should be a loss when the result is $loseResult") {
                assertFalse(bet.type.isWin(Result(loseResult)))
            }
        }
        on("streets of 25 and 28") {
            val winResult = 25
            val winResult2 = 30
            val loseResult = 7
            val bet = Bet(owner, 5, BetType.SixNumber(winResult, 26, 27, 28, 29, winResult2))
            it("Should be a win when the result is $winResult") {
                assertTrue(bet.type.isWin(Result(winResult)))
            }
            it("Should be a win when the result is $winResult2") {
                assertTrue(bet.type.isWin(Result(winResult)))
            }
            it("should be a loss when the result is $loseResult") {
                assertFalse(bet.type.isWin(Result(loseResult)))
            }
        }
        context("3 numbers are given in a two number bet") {
            on("numbers 1, 2, 3") {
                val winResult = 1
                val winResult2 = 2
                val loseResult = 3
                val bet = Bet(owner, 5, BetType.TwoNumber(winResult, winResult2))
                it("Should be a win when the result is $winResult") {
                    assertTrue(bet.type.isWin(Result(winResult)))
                }
                it("Should be a win when the result is $winResult2") {
                    assertTrue(bet.type.isWin(Result(winResult2)))
                }
                it("should be a loss when the result is $loseResult") {
                    assertFalse(bet.type.isWin(Result(loseResult)))
                }
            }
        }
        context("6 numbers are given in a four number bet") {
            on("numbers 1, 2, 3, 4, 5, 6") {
                val winResult = 1
                val winResult2 = 4
                val loseResult = 5
                val loseResult2 = 6
                val bet = Bet(owner, 5, BetType.FourNumber(1, 2, 3, 4, 5, 6))
                it("Should be a win when the result is $winResult") {
                    assertTrue(bet.type.isWin(Result(winResult)))
                }
                it("Should be a win when the result is $winResult2") {
                    assertTrue(bet.type.isWin(Result(winResult2)))
                }
                it("should be a loss when the result is $loseResult") {
                    assertFalse(bet.type.isWin(Result(loseResult)))
                }
                it("should be a loss when the result is $loseResult2") {
                    assertFalse(bet.type.isWin(Result(loseResult2)))
                }
            }
        }
    }
})