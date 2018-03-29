import com.goosvandenbekerom.roulette.core.BetType
import com.goosvandenbekerom.roulette.core.Game
import com.goosvandenbekerom.roulette.core.Player
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.junit.jupiter.api.Assertions.*

class GameSpec : Spek({

    given("a game") {
        val id: Long = 1
        val minimum = 5
        on("creation") {
            val game = Game(id, minimum)
            it("should not be open for betting") {
                assertFalse(game.bettingOpen)
            }
            it("should have a roulette wheel association") {
                assertNotNull(game.wheel)
            }
        }
        on("opening betting") {
            val game = Game(id, minimum)
            game.openBetting()
            it("should be open for betting") {
                assertTrue(game.bettingOpen)
            }
        }
        on("placing a bet") {
            val game = Game(id, minimum)
            val player = Player("a", "b", 5)
            game.openBetting()
            game.placeBet(player, 5, BetType.Odd())
            it("should have 1 bet") {
                assertEquals(1, game.bets.count())
            }
        }
        on("spinning the roulette wheel and resetting") {
            val game = Game(id, minimum)
            val player = Player("a", "b", 5)
            game.openBetting()
            game.placeBet(player, 5, BetType.Odd())

            game.playAndReset()
            it("should not be open for betting"){
                assertFalse(game.bettingOpen)
            }
            it("should have 1 result") {
                assertEquals(1, game.results.count())
            }
            it("should not have any bets") {
                assertEquals(0, game.bets.count())
            }
        }
    }
})