package dev.lynko.cources2023

import kotlin.jvm.JvmStatic

// Workshop #6 - special classes, objects, data classes



/* Рабочая зона */

// TODO 1: Добавь в data class 2-4 свойства.
data class VideoGame(val markdownOfGraphics : Int, val markdownGamePlay : Int, val numbersOfPlayers : Int, val hoursOfGamePlay : Int, val nameOfGame : String = "EmptyGame")

// TODO 2: Создай объект "VideoGamesTest", который будет использоваться для тестирования игр.
object VideoGamesTest {

    // Раскомментируй после объявления объекта.
    @JvmStatic
    fun main(args: Array<String>)  {
// TODO 3: Создай экземпляр класса "VideoGame".
//  Создай копию игры с помощью функции ата класса ".copy()", сохрани копию в другой переменной.
        val game = VideoGame(4, 3,2,23)
        val copy = game.copy()

// TODO 4: Выведи в консоль результат сравнения игры и её копии, используя оператор сравнения "==".
//  Результат должен быть типа Boolean "true".
        val equal = game.equals(copy)
        println("Objects are equal $equal")

// TODO 5: Создай массив игр. В момент создания, наполни его несколькими играми и массив в консоль.
        val game2 = VideoGame(5,5,1,56, "Forza Horizon 5")
        val games = arrayOf(game, copy, game2)
        games.forEach {el->
            println(el)
        }
    }
}



// TODO 6: Добавь новое свойство класса "VideoGame", присвой ему значение "по-умолчанию".
//  Как ты можешь убедиться, новое свойство со значением "по-умолчанию" не требует делать исправлений в таком коде.
//  Но надо помнить, что поведение созданных сущностей может измениться.
//  Запусти выполнение функции "main()" и посмотри результат.
