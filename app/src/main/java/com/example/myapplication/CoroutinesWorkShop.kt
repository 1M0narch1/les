package com.example.myapplication

import kotlinx.coroutines.*
import kotlin.random.Random
import kotlin.random.nextInt

//TODO 1 Создайте и сохраните в переменную coroutineScope, который по умолчанию будет использотвать
// Dispatcher.IO

val myСoroutineScope = CoroutineScope(Dispatchers.IO + Job())
val magickNumber = 15

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
/*  при    launch(Dispatchers.Main) {
                            println("Congrats! Your number is $number")
                        }
                    Exception in thread "DefaultDispatcher-worker-2" java.lang.IllegalStateException: Module with the Main dispatcher had failed to initialize. For tests Dispatchers.setMain from kotlinx-coroutines-test module can be used
	at kotlinx.coroutines.internal.MissingMainCoroutineDispatcher.missing(MainDispatchers.kt:118)
	at kotlinx.coroutines.internal.MissingMainCoroutineDispatcher.isDispatchNeeded(MainDispatchers.kt:96)
	at kotlinx.coroutines.internal.DispatchedContinuationKt.resumeCancellableWith(DispatchedContinuation.kt:319)
	at kotlinx.coroutines.intrinsics.CancellableKt.startCoroutineCancellable(Cancellable.kt:30)
	at kotlinx.coroutines.intrinsics.CancellableKt.startCoroutineCancellable$default(Cancellable.kt:25)
	at kotlinx.coroutines.CoroutineStart.invoke(CoroutineStart.kt:110)
	at kotlinx.coroutines.AbstractCoroutine.start(AbstractCoroutine.kt:126)
	at kotlinx.coroutines.BuildersKt__Builders_commonKt.launch(Builders.common.kt:56)
	at kotlinx.coroutines.BuildersKt.launch(Unknown Source)
	at kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(Builders.common.kt:47)
	at kotlinx.coroutines.BuildersKt.launch$default(Unknown Source)
	at com.example.myapplication.CoroutinesWorkShopKt$main$jobFinal$1$1.invokeSuspend(CoroutinesWorkShop.kt:27)
	at kotlin.coroutines.jvm.internal.BaseContinuationImpl.resumeWith(ContinuationImpl.kt:33)
	at kotlinx.coroutines.DispatchedTask.run(DispatchedTask.kt:106)
	at kotlinx.coroutines.internal.LimitedDispatcher.run(LimitedDispatcher.kt:42)
	at kotlinx.coroutines.scheduling.TaskImpl.run(Tasks.kt:95)
	at kotlinx.coroutines.scheduling.CoroutineScheduler.runSafely(CoroutineScheduler.kt:570)
	at kotlinx.coroutines.scheduling.CoroutineScheduler$Worker.executeTask(CoroutineScheduler.kt:749)
	at kotlinx.coroutines.scheduling.CoroutineScheduler$Worker.runWorker(CoroutineScheduler.kt:677)
	at kotlinx.coroutines.scheduling.CoroutineScheduler$Worker.run(CoroutineScheduler.kt:664)
	Suppressed: kotlinx.coroutines.DiagnosticCoroutineContextException: [StandaloneCoroutine{Cancelling}@7a27efb2, Dispatchers.IO]
Caused by: java.lang.RuntimeException: Stub!
	at android.os.Looper.getMainLooper(Looper.java:30)
	at kotlinx.coroutines.android.AndroidDispatcherFactory.createDispatcher(HandlerDispatcher.kt:55)
	at kotlinx.coroutines.internal.MainDispatchersKt.tryCreateDispatcher(MainDispatchers.kt:57)
	at kotlinx.coroutines.internal.MainDispatcherLoader.loadMainDispatcher(MainDispatchers.kt:38)
	at kotlinx.coroutines.internal.MainDispatcherLoader.<clinit>(MainDispatchers.kt:22)
	at kotlinx.coroutines.Dispatchers.getMain(Dispatchers.kt:57)
	... 9 more
	* */
                        withContext(Dispatchers.Default) {
                            println("Congrats! Your number is $number")
                        }
                    break
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
            withContext(Dispatchers.Default) {
                println("Start delay")
                doWork(getRandomNumber())
            }
            delay(7_000L)
            println("End delay")
            launch(Dispatchers.IO) {
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

