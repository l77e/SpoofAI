package main.kotlin.spoof

class SpoofGame(var numberOfCoins: Int) {
    fun processCoinTakeRequest(coinTakeRequest: CoinTakeRequest) : CoinTakeResponse {
        if (!checkCoinTakeRange(coinTakeRequest.numberOfCoinsToTake)) {
            error("Invalid CoinTakeRequest: number of coins to take out of range.")
        }
        val preposedCoinReduction = numberOfCoins - coinTakeRequest.numberOfCoinsToTake
        if (preposedCoinReduction <= 0) {
            return CoinTakeResponse(true, coinTakeRequest.player)
        }
        numberOfCoins -= coinTakeRequest.numberOfCoinsToTake
        return CoinTakeResponse(false, null)
    }

    private fun checkCoinTakeRange(numberOfCoins: Int) = numberOfCoins in 1..3

}