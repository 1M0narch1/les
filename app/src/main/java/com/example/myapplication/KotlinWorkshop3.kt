@file:Suppress("CanBeVal", "UNUSED_PARAMETER", "unused", "UNUSED_VARIABLE", "UNUSED_ANONYMOUS_PARAMETER")

package dev.lynko.cources2023

import java.util.*
import java.util.logging.Logger
import kotlin.random.Random

// Workshop #3 - functions, lambda, high-order function

object KotlinWorkshop3 {

    @JvmStatic
    fun main(args: Array<String>) {

        // Когда программа запущена, ввод с клавиатуры ожидается внизу, во вкладке RUN.
        // Не исправляй! Дано:
        val scanner = Scanner(System.`in`)
        val upperBound = getUpperBound(scanner)
        val nonNullUpperBound = upperBound ?: 10
        val randomNumber = Random.nextInt(nonNullUpperBound)
        val capacity = nonNullUpperBound
        val guesses = createIntArrayOfCapacity(capacity)

        var guessed = false
        var counter = 0
        while (!guessed && counter < capacity) {
            print("Input a number in range 0..$nonNullUpperBound inclusive: ")
            // Когда программа запущена, ввод с клавиатуры ожидается внизу, во вкладке RUN.
            val userInput: Int = getNextInput(scanner, nonNullUpperBound)
            guesses[counter] = userInput

            // TODO 1: Раскомментируй.
            //  Объяви функцию "playRound": она должна принимать на вход два Int аргумента и возвращать Boolean.
            //  См. ниже.
//            guessed = playRound(userInput, randomNumber)

            counter++
        }
    }

    // TODO 1: Раскомментируй.
    //  Объяви функцию "playRound": она должна принимать на вход два Int аргумента и возвращать Boolean.
    // TODO 2: Функция возвращает "true" и выводит сообщение "Congratulations!",
    //  когда ввод с клавиатуры равен значению "randomNumber";
    //  Если введено число больше "randomNumber", выведи сообщение "Your Guess is higher, continue." и верни false;
    //  Если введено число меньше "randomNumber", выведи сообщение "Your Guess is lower, continue." и верни false.
    //  Можно использовать наработки из workshop 2, с отличием, что здесь это вынесенная функция, нет цикла и возвращает результат.
//    private fun playRound(...) : ... {
//
//        return false
//    }

    }




    /* Для корректного прогона воркшопа не модифицируй утилиты ниже */

    private fun getUpperBound(scanner: Scanner): Int? {
        val upperLimit = 20
        val lowerLimit = 1

        println("Game: \"Guess a number\"")
        print("Enter maximum number in range 1..20 inclusive: ")
        return try {
            var input = scanner.nextInt()
            if (input in lowerLimit..upperLimit) {
                input

            } else {
                println("Wrong number. Use default as limit: $upperLimit")
                upperLimit
            }

        } catch (e: InputMismatchException) {
            null
        }
    }

    private fun getNextInput(scanner: Scanner, nonNullUpperBound: Int): Int {
        val lowerLimit = 0
        val badResult = -1

        return try {
            var input = scanner.nextInt()
            if (input in lowerLimit..nonNullUpperBound) {
                input

            } else {
                println("Wrong input. Should be $nonNullUpperBound or lower.")
                badResult
            }

        } catch (e: InputMismatchException) {
            val log = Logger.getLogger("KotlinWorkshop3Logger")
            log.throwing("KotlinWorkshop3Logger", "getNextInput()", e)
            badResult
        }
    }

    private fun createIntArrayOfCapacity(capacity: Int): IntArray {
        return IntArray(capacity) { i -> -1 }
    }
