@file:Suppress(
    "UNREACHABLE_CODE",
    "DuplicatedCode",
    "UNUSED_VARIABLE",
    "ControlFlowWithEmptyBody",
    "ConstantConditionIf",
    "RedundantNullableReturnType",
    "RedundantExplicitType",
    "unused"
)
package dev.lynko.cources2023

import java.util.*

// Практическая работа #1 - val, var, null, kotlin null безопасность, Элвис оператор

object KotlinWorkshop1 {

    @JvmStatic
    fun main(args: Array<String>) {
        // Не исправляй! Дано:
        val nullableElvisString: String? = null
        val nullableAssertionString: String? = "потенциально null"
        val emptyString = ""

        /* Рабочая зона */
        // TODO 1: Раскомментируй 32 - 33 строки.
        //  Присвой "notNullUserString" значение из "nullableElvisString".
        //  Если "nullableElvisString" равно null, сделай значение "notNullUserString" равным значению пустой строки "emptyString".
        //  Исправить присвоение используя Элвис-оператор "?:".
//        var notNullUserString: String =
//        println("Строка результат равна $notNullUserString")

        // TODO 2: Раскомментируй 38 - 39 строки.
        //  По факту мы знаем, что значение "nullableAssertionString" не равно null.
        //  Сделай принудительное присвоение используя !! оператор.
//        notNullUserString =
//        println("Строка результат равна $notNullUserString")

        // TODO 3: Раскомментируй 47 - 48 строки. Сложи две переменные.
        //  Если firstNumber равно null, сумма должна быть null. Если secondNumber равно null, сумма должна быть равна значение firstNumber.
        //  Используй проверку на null '?', для сложения используй функцию '.plus()'. Внутри '.plus()' используй '?:'.
        val notNullAlternative = 0
        val firstNumber: Int? = 10
        val secondNumber: Int? = 20
//        val sum : Int? =
//        println("Сумма равна {$sum}")
    }
}