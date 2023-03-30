package ru.netology

import comissionAmount
import masterCardMaestro
import masterCardMaestroLimitsCheck
import org.junit.Test
import org.junit.Assert.*
import vKpay
import vKpayLimitsCheck
import visaMir
import visaMirLimitsCheck

class MainKtTest {

    @Test
    fun comissionAmountTest1() {
        val Type = "MasterCard"
        val amount = 3_000
        val previousAmount = 6_000
        val result = comissionAmount(
            cardType = Type,
            transferAmount = amount,
            previousMonthTransferAmount = previousAmount
        )
        assertEquals(masterCardMaestroLimitsCheck(amount, previousAmount), result)
    }

    @Test
    fun comissionAmountTest2() {
        val Type = "Visa"
        val amount = 3_000
        val previousAmount = 6_000
        val result = comissionAmount(
            cardType = Type,
            transferAmount = amount,
            previousMonthTransferAmount = previousAmount
        )
        assertEquals(visaMirLimitsCheck(amount, previousAmount), result)
    }

    @Test
    fun comissionAmountTest3() {
        val Type = "VKpay"
        val amount = 3_000
        val previousAmount = 6_000
        val result = comissionAmount(
            cardType = Type,
            transferAmount = amount,
            previousMonthTransferAmount = previousAmount
        )
        assertEquals(vKpayLimitsCheck(amount, previousAmount), result)
    }

    @Test
    fun comissionAmountTest4() {
        val Type = "ХЗ"
        val amount = 3_000
        val previousAmount = 6_000
        val result = comissionAmount(
            cardType = Type,
            transferAmount = amount,
            previousMonthTransferAmount = previousAmount
        )
        assertEquals(0.0, result)
    }

    @Test
    fun masterCardMaestroTest() {
        val amount = 3_000
        val previousAmount = 6_000
        val result = masterCardMaestro(
            transferAmount = amount,
            previousMonthTransferAmount = previousAmount
        )
        assertEquals(0.toDouble(), result, 0.0001)
    }

    @Test
    fun masterCardMaestroTest2() {
        val amount = 45_000
        val previousAmount = 35_000
        val result = masterCardMaestro(
            transferAmount = amount,
            previousMonthTransferAmount = previousAmount
        )
        assertEquals(290.0, result, 0.0001)
    }

    @Test
    fun masterCardMaestroLimitsCheckTest1() {
        val amount = 45_000
        val previousAmount = 35_000
        val result: Any = masterCardMaestro(
            transferAmount = amount,
            previousMonthTransferAmount = previousAmount
        )
        assertEquals(masterCardMaestro(amount, previousAmount), result)
    }

    @Test
    fun masterCardMaestroLimitsCheckTest2() {
        val amount = 445_000
        val previousAmount = 835_000
        val result: Any = masterCardMaestroLimitsCheck(transferAmount = amount, previousMonthTransferAmount = previousAmount)
        assertEquals("Вы превысили лимит", result)
    }

    @Test
    fun visaMirTest() {
        val amount = 3_000
        val previousAmount = 6_000
        val result = visaMir(
            transferAmount = amount,
            previousMonthTransferAmount = previousAmount
        )
        assertEquals(35.toDouble(), result, 0.0001)
    }

    @Test
    fun visaMirTest2() {
        val amount = 45_000
        val previousAmount = 35_000
        val result = visaMir(
            transferAmount = amount,
            previousMonthTransferAmount = previousAmount
        )
        assertEquals(337.5, result, 0.0001)
    }

    @Test
    fun visaMirLimitsCheckTest1() {
        val amount = 45_000
        val previousAmount = 35_000
        val result: Any = visaMirLimitsCheck(
            transferAmount = amount,
            previousMonthTransferAmount = previousAmount
        )
        assertEquals(visaMir(amount, previousAmount), result)
    }

    @Test
    fun visaMirLimitsCheckTest2() {
        val amount = 445_000
        val previousAmount = 635_000
        val result: Any = visaMirLimitsCheck(
            transferAmount = amount,
            previousMonthTransferAmount = previousAmount
        )
        assertEquals("Вы превысили лимит", result)
    }



    @Test
    fun vKpayTest() {
        val amount = 3_000
        val previousAmount = 6_000
        val result = vKpay(
            transferAmount = amount,
            previousMonthTransferAmount = previousAmount
        )
        assertEquals(0.toDouble(), result, 0.0001)
    }

    @Test
    fun vKpayLimitsCheckTest1(){
        val amount = 3_000
        val previousAmount = 6_000
        val result = vKpayLimitsCheck(
            transferAmount = amount,
            previousMonthTransferAmount = previousAmount
        )
        assertEquals(vKpay(amount, previousAmount), result)
    }

    @Test
    fun vKpayLimitsCheckTest2(){
        val amount = 25_000
        val previousAmount = 56_000
        val result = vKpayLimitsCheck(
            transferAmount = amount,
            previousMonthTransferAmount = previousAmount
        )
        assertEquals("Вы превысили лимит", result)
    }

}

