package main.kotlin.spoof

import java.util.*

val playerScores = arrayOf(0, 0)

fun initMessage(): String = "---Spoof Game---"

fun main() {
    println(initMessage())
    repeat(10000) {
        smartComputerVsComputer()
    }
    //smartComputerVsHuman()
    print("player 1: ${playerScores[0]}")
    print("player 2: ${playerScores[1]}")
}

fun randomComputerVsHuman() {
    println("Random Computer vs Human...")
    val game = SpoofGame(20)
    val humanPlayer = Player(UUID.randomUUID())
    val computerPlayer = Player(UUID.randomUUID())
    var result: CoinTakeResponse
    while (true) {
        val computerAttempt = (1..3).random()
        println("Computer take(s)... $computerAttempt coins.")
        result = game.processCoinTakeRequest(
            CoinTakeRequest(computerPlayer, computerAttempt)
        )
        if (result.isGameOver()) {
            break
        }
        println("There are now ${game.numberOfCoins} coin(s).")

        println("Please type a number between 1-3 coin(s) to take.")
        val humanAttempt = readLine()!!
        println("Human takes... $computerAttempt coin(s)")
        result = game.processCoinTakeRequest(
            CoinTakeRequest(humanPlayer, humanAttempt.toInt())
        )
        if (result.isGameOver()) {
            break
        }
        println("There are now ${game.numberOfCoins} coin(s).")
    }

    if (result.loosingPlayer == computerPlayer) {
        println("Human wins, computer looses.")
    } else {
        println("Computer wins, human looses.")
    }
    println("Game termination.")
}

fun smartComputerVsHuman() {
    println("Random Computer vs Computer...")
    val game = SpoofGame(11)
    val computer1Player = ComputerPlayer()
    val humanPlayer = Player(UUID.randomUUID())
    var result: CoinTakeResponse
    while (true) {
        val computer1Attempt = computer1Player.getNextMove(game)
        println("Computer1 take(s)... ${computer1Attempt.numberOfCoinsToTake} coins.")
        result = game.processCoinTakeRequest(computer1Attempt)
        if (result.isGameOver()) { break }
        println("There are now ${game.numberOfCoins} coin(s).")

        println("Please type a number between 1-3 coin(s) to take.")
        val humanAttempt = readLine()!!
        println("Human takes... $humanAttempt coin(s)")
        result = game.processCoinTakeRequest(
            CoinTakeRequest(humanPlayer, humanAttempt.toInt())
        )
        if (result.isGameOver()) {
            break
        }
        println("There are now ${game.numberOfCoins} coin(s).")
    }

    if (result.loosingPlayer == computer1Player.player) {
        println("Computer2 wins, computer1 looses.")
        playerScores[1] += 1
    } else {
        println("Computer1 wins, computer2 looses.")
        playerScores[0] += 1
    }
    println("Game termination.")
}

fun randomComputerVsComputer() {
    println("Random Computer vs Computer...")
    val game = SpoofGame(10000000)
    val computer1Player = Player(UUID.randomUUID())
    val computer2Player = Player(UUID.randomUUID())
    var result: CoinTakeResponse
    while (true) {
        val computer1Attempt = (1..3).random()
        println("Computer1 take(s)... $computer1Attempt coins.")
        result = game.processCoinTakeRequest(
            CoinTakeRequest(computer1Player, computer1Attempt)
        )
        if (result.isGameOver()) {
            break
        }
        println("There are now ${game.numberOfCoins} coin(s).")

        val computer2Attempt = (1..3).random()
        println("Computer2 take(s)... $computer2Attempt coins.")
        result = game.processCoinTakeRequest(
            CoinTakeRequest(computer2Player, computer2Attempt)
        )
        if (result.isGameOver()) {
            break
        }
        println("There are now ${game.numberOfCoins} coin(s).")
    }

    if (result.loosingPlayer == computer1Player) {
        println("Computer2 wins, computer1 looses.")
    } else {
        println("Computer1 wins, computer2 looses.")
    }
    println("Game termination.")
}

fun smartComputerVsComputer() {
    println("Random Computer vs Computer...")
    val game = SpoofGame(numberOfCoins = (0..1000).random())
    val computer1Player = ComputerPlayer()
    val computer2Player = Player(UUID.randomUUID())
    var result: CoinTakeResponse
    while (true) {
        val computer1Attempt = computer1Player.getNextMove(game)
        println("Computer1 take(s)... ${computer1Attempt.numberOfCoinsToTake} coins.")
        result = game.processCoinTakeRequest(computer1Attempt)
        if (result.isGameOver()) { break }
        println("There are now ${game.numberOfCoins} coin(s).")

        val computer2Attempt = (1..3).random()
        println("Computer2 take(s)... $computer2Attempt coins.")
        result = game.processCoinTakeRequest(CoinTakeRequest(computer2Player, computer2Attempt))
        if (result.isGameOver()) { break }
        println("There are now ${game.numberOfCoins} coin(s).")
    }

    if (result.loosingPlayer == computer1Player.player) {
        println("Computer2 wins, computer1 looses.")
        playerScores[1] += 1
    } else {
        println("Computer1 wins, computer2 looses.")
        playerScores[0] += 1
    }
    println("Game termination.")
}