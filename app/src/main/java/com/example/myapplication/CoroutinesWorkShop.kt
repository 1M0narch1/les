package com.example.myapplication

import kotlinx.coroutines.*
import kotlin.random.Random
import kotlin.random.nextInt

//TODO 1 Создайте и сохраните в переменную coroutineScope, который по умолчанию будет использотвать
// Dispatcher.IO

val myСoroutineScope = CoroutineScope(Dispatchers.IO)

fun main()  {
    //  TODO 2 Запустите корутину в созданном coroutineScope.
    //   Корутина должна вызывать функцию getRandomNumber один раз в 2 секунды, и в случае, если полученное число
    //   меньше 15, повторять тоже самое, если полученное число больше либо равно 15, то корутина должна переключиться
    //   на Dispatcher.Main и вывести в консоль "Congrats! Your number is $number" и завершить свою работу

    myСoroutineScope.launch {
        println("Coroutine TODO 2 start")
        while(true) {
            var number = getRandomNumber()
            if (number >= 15) {
                launch(Dispatchers.Main) {
                    println("Congrats! Your number is $number")
                    break
                }
            }
            delay(200L)
        }

        println("Coroutine TODO 2 end")
    }

    //TODO 3 Запустите корутину в созданном coroutineScope и сохраните ее Job.
    // Корутина должна приостановить свою работу на 15 секунд. После истечения этого времени она
    // должна выбросить NoSuchMethodError(). Чтобы избежать завершения всего метода main,
    // раскомментируйте  delay(10_000L) и после него проверьте с помощью job активна ли созданная
    // корутина, и если активна, завершите ее вручную

    val job = myСoroutineScope.launch {
        println("Coroutine TODO 3 start")
        delay(1500L)
        throw NoSuchMethodError()
        println("Coroutine TODO 3 end")
    }
    delay(10_000L)
     if (job.isActive) {
         job.cancel()
     }


    //TODO 4 Исправьте написанный код в корутине так, чтобы добиться вывода текста в таком порядке:
    // "Coroutine TODО 4 start"
    // "Start delay"
    // "Start work..."
    // "Work complete. Number: $value"
    // "End delay"
    // "Last step."
    // "Coroutine TODО 4 end".
    // Написаные println трогать и добавлять новые запрещается)))


    val jobFinal = myСoroutineScope.launch {
        println("Coroutine TODO 4 start")
        withContext(Dispatchers.Default) {
            doWork(getRandomNumber())
        }
        println("Start delay")
        delay(7_000L)
        println("End delay")
        launch(Dispatchers.IO) {
            delay(1000L)
            println("Coroutine TODO 4 end")
        }
        println("Last step.")
    }

    //Не убирать
    while (jobFinal.isActive) {

    }


}

suspend fun getRandomNumber(): Int = Random(System.currentTimeMillis()).nextInt(0..20)

suspend fun doWork(value: Int) {
    println("Start work...")
    delay(5_000L)
    println("Work complete. Number: $value")
}

