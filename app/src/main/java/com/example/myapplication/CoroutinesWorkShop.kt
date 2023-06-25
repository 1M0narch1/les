package com.example.myapplication

import kotlinx.coroutines.*
import kotlin.random.Random
import kotlin.random.nextInt

//TODO 1 Создайте и сохраните в переменную coroutineScope, который по умолчанию будет использотвать
// Dispatcher.IO

val myСoroutineScope = CoroutineScope(Dispatchers.IO + Job())
val magickNumber = 15 //За отдельную переменную респект

fun main()  {
    //  TODO 2 Запустите корутину в созданном coroutineScope.
    //   Корутина должна вызывать функцию getRandomNumber один раз в 2 секунды, и в случае, если полученное число
    //   меньше 15, повторять тоже самое, если полученное число больше либо равно 15, то корутина должна переключиться
    //   на Dispatcher.Main и вывести в консоль "Congrats! Your number is $number" и завершить свою работу


   val jobFinal = myСoroutineScope.launch {

        myСoroutineScope.launch {
            println("Coroutine TODO 2 start")
            while (true) {
                val number = getRandomNumber()
                if (number >= magickNumber) {
                    //Все верно, моя ошибка
                    //Dispatcher.Main нельзя использовать в kotlin файлах
/*  при    launch(Dispatchers.Main) {
                            println("Congrats! Your number is $number")
                        }
                    Exception in thread "DefaultDispatcher-worker-2" java.lang.IllegalStateException: Module with the Main dispatcher had failed to initialize. For tests Dispatchers.setMain from kotlinx-coroutines-test module can be used
	*/
                        withContext(Dispatchers.Default) {
                            println("Congrats! Your number is $number")
                        }
                    break
                }
                delay(200L) //2 секунды это 2000L))
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
            println("Coroutine TODO 3 end")
        }

        delay(10_000)

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
            withContext(Dispatchers.Default) { //Необходимо было поменять на launch, а println("Start delay") оставить там, где он был изначально
                println("Start delay") // Написаные println трогать и добавлять новые запрещается)))
                doWork(getRandomNumber())
            }
            delay(7_000L)
            println("End delay")
            launch(Dispatchers.IO) { // А тут необходимо было поменять на withContext, чтобы изначально выполнился код в нем, а после то, что после блока withContext
                delay(1000L)
                println("Coroutine TODO 4 end")
            }
            println("Last step.")
        }

    }


        //Не убирать
        while (jobFinal.isActive) {
            Thread.sleep(30000)
        }
}

suspend fun getRandomNumber(): Int = Random(System.currentTimeMillis()).nextInt(0..20)

suspend fun doWork(value: Int) {
    println("Start work...")
    delay(5_000L)
    println("Work complete. Number: $value")
}

