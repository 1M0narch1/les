@file:Suppress("MayBeConstant", "unused", "UNUSED_VARIABLE")

package dev.lynko.cources2023
// workshop #8 - const, companion object, extension func*

/*
 * Сокращаем телефон до максимально докустимой длины maxLength
 * и пишем функцию экстеншен на лист, которая заменяет каждый i-й элемент номером телефона
 */

// TODO 1: Сделать maxLength const, которая будет видна только внутри класса Person
val maxLength = 12

// TODO 2: Сделать companionConstant частью companion object
val companionConstant = 12

class Person(phoneCode: String) {

    val code = if (phoneCode.length > maxLength) phoneCode.subSequence(0, maxLength) else phoneCode

    companion object {
        // TODO 2
    }

    //TODO 3: Сделай эту функцию расширением листа вне класса Person
    private fun replacePlacesWithThePhoneCode(list: List<Any>, placeNum: Int = 3): List<Any> {
        return list.mapIndexed { index, any -> if (index % placeNum == 0) code else any}
    }
}

fun main(){
    val list = mutableListOf("1", 3, 4, "Patrick", 3.4, "123-59")

    val p = Person("45-45-45")


    // TODO 4: Раскомментируй это после выполнения TODO 1
    //  println(Person.maxLength)

    //TODO 5: Раскомментируй это после выполнения TODO 3
    // list.replacePlacesWithThePhoneCode(p, 4)
}

