package main.kotlin.spoof

class ComputerPlayer(val player: Player = Player())  {

    fun getNextMove(spoofGame: SpoofGame) : CoinTakeRequest =  CoinTakeRequest(player, getCoinsToTake(spoofGame))

    private fun getCoinsToTake(spoofGame: SpoofGame) : Int = when {
            spoofGame.numberOfCoins < 3 -> 1
            spoofGame.numberOfCoins == 3 -> 2
            else -> 3
        }
}