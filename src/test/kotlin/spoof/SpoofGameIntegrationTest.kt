package test.kotlin.spoof

import main.kotlin.spoof.CoinTakeRequest
import main.kotlin.spoof.Player
import main.kotlin.spoof.SpoofGame
import org.junit.jupiter.api.Test
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertNull

class SpoofGameIntegrationTest {

    @Test
    fun `Sample game produces expected winner and looser`() {
        val players = listOf(
            Player(UUID.randomUUID()),
            Player(UUID.randomUUID())
        )
        val game = SpoofGame(
            numberOfCoins = 8
        )
        assertNull(
            game.processCoinTakeRequest(CoinTakeRequest(players[0], 3)).loosingPlayer
        )

        assertNull(
            game.processCoinTakeRequest(CoinTakeRequest(players[1], 1)).loosingPlayer
        )

        assertNull(
            game.processCoinTakeRequest(CoinTakeRequest(players[0], 3)).loosingPlayer
        )

        assertEquals(
            game.processCoinTakeRequest(CoinTakeRequest(players[1], 1)).loosingPlayer,
            players[1]
        )
    }
}