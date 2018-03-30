import com.goosvandenbekerom.roulette.core.DOUBLE_ZERO
import com.goosvandenbekerom.roulette.core.Result
import com.goosvandenbekerom.roulette.core.RouletteColor
import com.goosvandenbekerom.roulette.core.ZERO
import com.goosvandenbekerom.roulette.core.exception.NonExistingRouletteResult
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.context
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.function.Executable

class ResultSpec : Spek({
    given("a result") {
        context("of number 5") {
            val result = Result(5)
            it("should be of the color red") {
                assertEquals(RouletteColor.RED, result.color)
            }
        }
        context("of number $ZERO") {
            val result = Result(ZERO)
            it("should be of the color green") {
                assertEquals(RouletteColor.GREEN, result.color)
            }
        }
        context("of number $DOUBLE_ZERO") {
            val result = Result(DOUBLE_ZERO)
            it("should be of the color green") {
                assertEquals(RouletteColor.GREEN, result.color)
            }
        }
        context("of number 10") {
            val result = Result(10)
            it("should be of the color black") {
                assertEquals(RouletteColor.BLACK, result.color)
            }
        }
        context("of number 11") {
            val result = Result(11)
            it("should be of the color black") {
                assertEquals(RouletteColor.BLACK, result.color)
            }
        }
        context("of number 18") {
            val result = Result(18)
            it("should be of the color red") {
                assertEquals(RouletteColor.RED, result.color)
            }
        }
        context("of number 19") {
            val result = Result(19)
            it("should be of the color red") {
                assertEquals(RouletteColor.RED, result.color)
            }
        }
        context("of number 28") {
            val result = Result(28)
            it("should be of the color black") {
                assertEquals(RouletteColor.BLACK, result.color)
            }
        }
        context("of number 29") {
            val result = Result(29)
            it("should be of the color black") {
                assertEquals(RouletteColor.BLACK, result.color)
            }
        }
        context("of a positive non existing roulette number") {
            it("should throw a non existing number error") {
                assertThrows(NonExistingRouletteResult::class.java, Executable { Result(100) })
            }
        }
        context("of a negative non existing roulette number") {
            it("should throw a non existing number error") {
                assertThrows(NonExistingRouletteResult::class.java, Executable { Result(-100) })
            }
        }
    }
})