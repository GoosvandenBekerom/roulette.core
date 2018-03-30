import com.goosvandenbekerom.roulette.core.BetType
import com.goosvandenbekerom.roulette.core.Game
import com.goosvandenbekerom.roulette.core.Player
import com.goosvandenbekerom.roulette.core.exception.AmountToLowException
import com.goosvandenbekerom.roulette.core.exception.BettingClosedException
import com.goosvandenbekerom.roulette.core.exception.NotEnoughChipsException
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.context
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.function.Executable

class PlayerSpec : Spek({
    given("a player with 100 chips") {
        val gameId1: Long = 1
        context("a game with id $gameId1 and a minimum bet amount of 5") {
            val game = Game(gameId1, 5)
            on("betting 5 on odd") {
                val player = Player("Goos", "blue", 100)
                game.openBetting()
                game.placeBet(player, 5, BetType.Odd())
                it("should have 95 chips remaining") {
                    assertEquals(95, player.chipAmount)
                }
            }
            on("winning a bet of 5 in a 1-to-2 spot") {
                val player = Player("Goos", "blue", 100)
                game.openBetting()
                game.placeBet(player, 5, BetType.FirstColumn())
                game.playAndReset()
                it("should have 110 chips remaining") {
                    assertEquals(110, player.chipAmount)
                }
            }
            on("betting 1") {
                game.openBetting()
                it("should give an error saying the bet amount is too low") {
                    assertThrows(AmountToLowException::class.java, Executable {
                        game.placeBet(Player("a", "b", 10), 1, BetType.Odd())
                    })
                }
            }
            on("placing a bet when betting is closed") {
                game.closeBetting()
                it("should give an error saying the bet amount is too low") {
                    assertThrows(BettingClosedException::class.java, Executable {
                        game.placeBet(Player("a", "b", 10), 5, BetType.Odd())
                    })
                }
            }
            on("placing a bet of 10 when it only owns 5") {
                game.openBetting()
                it("should give an error saying the bet amount is too low") {
                    assertThrows(NotEnoughChipsException::class.java, Executable {
                        game.placeBet(Player("a", "b", 5), 10, BetType.Odd())
                    })
                }
            }
        }
    }
})