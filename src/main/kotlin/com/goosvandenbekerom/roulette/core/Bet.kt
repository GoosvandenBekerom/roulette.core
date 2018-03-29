package com.goosvandenbekerom.roulette.core

data class Bet(val player: Player, val amount: Int, val type: BetType) {
    fun payout(result: Result) {
        if (!type.isWin(result)) return
        player.addChips(amount * type.multiplier)
    }
}