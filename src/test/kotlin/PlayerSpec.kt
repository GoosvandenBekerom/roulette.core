import com.goosvandenbekerom.roulette.core.BetType
import com.goosvandenbekerom.roulette.core.Game
import com.goosvandenbekerom.roulette.core.Player
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.context
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.junit.jupiter.api.Assertions.assertEquals

class PlayerSpec : Spek({
    given("a player with 100 chips") {
        val gameId1: Long = 1
        context("a game with id $gameId1") {
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
        }
    }
})