package com.example.myapplication.repository

import com.example.myapplication.database.dao.AnimalsDao
import com.example.myapplication.model.Animal
import kotlinx.coroutines.*

class AnimalsRepository(val animalsDao: AnimalsDao) {

    private val job = SupervisorJob()
    private val animalsScope = CoroutineScope(job + Dispatchers.IO)


    suspend fun insertAnimal(animal: Animal) {
        animalsScope.launch {
            animalsDao.insert(animal)
        }
    }

    suspend fun getAllAnimas(): List<Animal> {
        return animalsScope.async {
            animalsDao.getAll()
        }.await()
    }

    suspend fun deleteAll() {
        animalsScope.launch {
            animalsDao.deleteAll()
        }
    }

    //TODO(Добавьте метод deleteAll, который будет полностью удалять всех питомцев из таблицы. Пока
    // его можно не вызывать, поработаем с ним позже)
}