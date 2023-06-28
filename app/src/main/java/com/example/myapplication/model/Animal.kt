package com.example.myapplication.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "animal"
)
data class Animal(
    //Изменил тип для спинера, показалось так удобнее
    val type: String,
    val name: String,
    val age: Int,
//    @ColumnInfo(name = "w")
    val weight: Double,
    val description: String,
    val createdAt: Long,
    //TODO("Добавьте поле description, которое будет содержать описание питомца")
    //TODO("Добавьте поле createdAt, которое будет равно времени создания питомца(System.currentTimeMillis)")
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
) {

    companion object {
        const val TYPE_CAT: String = "Cat"
        const val TYPE_DOG: String = "Dog"
        const val TYPE_ANDROID: String = "Android"

    }
}
