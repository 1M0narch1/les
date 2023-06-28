package com.example.myapplication.database.dao

import androidx.room.*
import com.example.myapplication.model.Animal

@Dao
interface AnimalsDao {

    @Query("SELECT * FROM animal")
    fun getAll(): List<Animal>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(animal: Animal)

    @Query("UPDATE animal SET weight = :newWeight WHERE id = :id")
    fun updateWeight(id: Int, newWeight: Double)

    @Query("DELETE FROM animal WHERE id = :id")
    fun deleteAnimal(id: Int)

    @Query("DELETE FROM animal")
    fun deleteAll()

}