import com.goosvandenbekerom.roulette.core.Wheel
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.junit.jupiter.api.Assertions.assertNotNull

class WheelSpec : Spek({
    given("a wheel") {
        val wheel = Wheel(1)
        on("spinning a ball") {
            val result = wheel.spin()
            it("should return a result") {
                assertNotNull(result)
            }
        }
    }
})