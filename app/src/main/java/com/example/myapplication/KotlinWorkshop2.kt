@file:Suppress(
    "UNREACHABLE_CODE",
    "DuplicatedCode",
    "UNUSED_VARIABLE",
    "ControlFlowWithEmptyBody",
    "ConstantConditionIf"
)

package dev.lynko.cources2023

import java.util.*
import kotlin.random.Random

// Практическая работа #2 - control flow (if, when), arrays, for loop, if expression, return & jumps

object KotlinWorkshop2 {

    @JvmStatic
    fun main(args: Array<String>) {
        /* Рабочая зона */
        // Когда программа запущена, ввод с клавиатуры ожидается внизу, во вкладке RUN.
        // Кликни в зоне открытого окна и введи строку.
        // Не исправляй! Дано:
        val upperBound = getUpperBound()
        val nonNullUpperBound = upperBound ?: 10
        val randomNumber = Random.nextInt(nonNullUpperBound)
        val scanner = Scanner(System.`in`)

        while (true) {
            // TODO 1: Напиши логику сравнения "userInput" с "randomNumber" используя If-Else выражение.
            //  Когда ввод с клавиатуры равен значению "randomNumber", прерви бесконечный цикл while
            //  используя ключевое слово "break" и выведи сообщение "Поздравляю! Задуманное число х"
            //  Если введено число меньше "randomNumber", выведи сообщение "Ваше число меньше задуманного, пожалуйста продолжаем."
            //  Если введено число больше "randomNumber", выведи сообщение "Ваше число больше задуманного, пожалуйста продолжаем."

            print("Введите число в диапазоне 0..$nonNullUpperBound включительно: ")
            // Сохраняем введённое с клавиатуры число в "userInput".
            val userInput: Int = scanner.nextInt()
            if (true) {

            }
        }
    }

    /* Для корректного прогона воркшопа не модифицируй утилиты ниже */
    private fun getUpperBound(): Int? {
        println("Программа 1. \"Угадай число\"")
        print("Введите число максимум в диапазоне 10..20 включительно: ")
        val scanner = Scanner(System.`in`)
        return try {
            scanner.nextInt()

        } catch (e: InputMismatchException) {
            null
        }
    }
}