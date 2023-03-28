import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun masterCardMaestro() {
        val amount = 3_000
        val previousAmount = 6_000

        val result: Any = masterCardMaestro(transferAmount = amount, previousAmount = previousAmount)

        assertEquals(0.0, result)
    }
}