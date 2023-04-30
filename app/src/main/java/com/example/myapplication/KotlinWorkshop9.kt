@file:Suppress("unused")

package dev.lynko.cources2023

// workshop #9 - generics
/*
 * Класс программиста, который может учить и забывать концепты на определенном языке.
 */

fun main() {
    val p = Programmer<Kotlin>()

    //TODO 5: Раскоментируй строки 14, 16, 17, 25 после выполнения всех TODO
    p.learn(Kotlin("basics"))

    p.learn(Kotlin("generics"))
    p.learn(Kotlin("coroutines"))

    println(p.howManyConceptsDoIKnow())
    // should be equal to 3

    println(p.lastConcept())
    //should be Kotlin(element=coroutines)

    p.forget(Kotlin("generics"))
    println(p.howManyConceptsDoIKnow())
    // should be equal to 2
}


class Programmer<T: Language> {
    val concepts : MutableList<T> = mutableListOf()

    fun howManyConceptsDoIKnow(): Int = concepts.size

    // TODO 1: Добавь функцию learn с новой концепцие
    fun learn(concept : T) {
        concepts.add(howManyConceptsDoIKnow(),concept)
    }

    //TODO 2: Добавь функцию forget с одной концепцией для забывания
    fun forget(concept : T) {
        concepts.remove(concept)
    }

    // TODO 3: Реализуй функцию howManyConceptsDoIKnow, которая будет возвращать количество концептов, которые знает программист

    // TODO 4: Реализуй функцию lastConcept, которая будет возращать последний выученный концепт

    fun lastConcept(): T = concepts[concepts.lastIndex]
}

interface Language{
    val element: String
}

data class JavaLanguage(override val element: String) : Language
data class Kotlin(override val element: String): Language
data class Swift(override val element: String): Language
data class C_Sharp(override val element: String): Language