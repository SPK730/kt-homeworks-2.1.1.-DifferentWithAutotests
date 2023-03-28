fun main() {
    var cardType: String = "VKpay"
    var transferAmount: Int = 0
    var previousMonthTransferAmount: Int = 0
    val comission = comissionAmount("VKpay", 3_000, 6_000)//Введите тип карты, сумму перевода и сумму переводов за текущий месяц
    println("Сумма комиссии за перевод: " + (comission) + " руб.")
}

fun comissionAmount(cardType: String, transferAmount: Int, previousMonthTransferAmount: Int): Any {
    return when {
        (cardType == "MasterCard" || cardType == "Maestro") -> MasterCardMaestroLimitsCheck(transferAmount, previousMonthTransferAmount)
        (cardType == "Visa" || cardType == "Мир") -> VisaMirLimitsCheck(transferAmount, previousMonthTransferAmount)
        (cardType == "VKpay") -> VKpayLimitsCheck(transferAmount, previousMonthTransferAmount)
        else -> 0.0
    }
}

fun MasterCardMaestroLimitsCheck(
    transferAmount: Int,
    previousMonthTransferAmount: Int): Any { //проверка месячных лимитов
    return when {(transferAmount < 150_000) || previousMonthTransferAmount < 600_000 -> MasterCardMaestro(transferAmount, previousMonthTransferAmount)
        else -> "Вы превысили лимит"
    }
}

fun MasterCardMaestro(transferAmount: Int, previousMonthTransferAmount: Int): Any {
    return when {((transferAmount + previousMonthTransferAmount) > 75_000) -> (transferAmount / 100 * 0.6) + 20 //до 75000 в мес комиссия 0, если больше 0,6% +20 руб)
        else -> 0.0
    }
}

fun VisaMirLimitsCheck(transferAmount: Int, previousMonthTransferAmount: Int): Any { //проверка месячных лимитов
    return when {(transferAmount < 150_000) || previousMonthTransferAmount < 600_000 -> VisaMir(transferAmount,previousMonthTransferAmount)
        else -> "Вы превысили лимит"
    }
}

fun VisaMir(transferAmount: Int, previousMonthTransferAmount: Int): Double {
    return when {(transferAmount / 100 * 0.75) > 35.0 -> transferAmount / 100 * 0.75
        else -> 35.0
    }
}

fun VKpayLimitsCheck(transferAmount: Int, previousMonthTransferAmount: Int): Any { //проверка месячных лимитов VKpay
    return when {(transferAmount < 15_000) || (transferAmount + previousMonthTransferAmount < 40_000) -> VKpay(transferAmount, previousMonthTransferAmount)
        else -> "Вы превысили лимит"
    }
}

fun VKpay(transferAmount: Int, previousMonthTransferAmount: Int): Any {
    return 0.0

}
