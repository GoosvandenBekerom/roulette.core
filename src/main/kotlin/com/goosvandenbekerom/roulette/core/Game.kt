package com.goosvandenbekerom.roulette.core

import com.goosvandenbekerom.roulette.core.exception.AmountToLowException
import com.goosvandenbekerom.roulette.core.exception.BettingClosedException

data class Game(val id: Long, val minimumBet: Int) {
    val wheel = Wheel(id)
    val bets = mutableSetOf<Bet>()
    val results = mutableSetOf<Result>()

    var bettingOpen = false
        private set

    fun openBetting() {
        bettingOpen = true
    }

    fun closeBetting() {
        bettingOpen = false
    }

    fun placeBet(player: Player, amount: Int, type: BetType) {
        if (!bettingOpen) throw BettingClosedException()
        if (amount < minimumBet) throw AmountToLowException(amount, minimumBet)
        player.removeChips(amount)
        bets.add(Bet(player, amount, type))
    }

    fun playAndReset() : Result {
        closeBetting()
        val result = wheel.spin()
        results.add(result)
        payoutWinningBets(result)
        bets.clear()
        return result
    }

    private fun payoutWinningBets(result: Result) {
        bets.forEach {
            if (it.type.isWin(result)) it.payout()
        }
    }

    override fun toString() = "Game(id=$id, minimumBet=$minimumBet, bettingOpen=$bettingOpen. amountOfBets=${bets.count()})"
}
