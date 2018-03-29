package com.goosvandenbekerom.roulette.core

data class Bet(val player: Player, val amount: Int, val type: BetType) {
    fun payout() {
        player.addChips(amount * type.multiplier)
    }
}