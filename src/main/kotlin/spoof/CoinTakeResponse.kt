package main.kotlin.spoof

class CoinTakeResponse(
    private val gameIsOver: Boolean,
    val loosingPlayer : Player?) {
    fun isGameOver(): Boolean = gameIsOver
}