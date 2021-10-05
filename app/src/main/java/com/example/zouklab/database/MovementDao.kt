package com.example.zouklab.database

import androidx.room.*
import com.example.zouklab.database.entities.Movement

@Dao
interface MovementDao {

    @Insert
    fun insert(movement: Movement)

    @Update
    fun update(movement: Movement)

    @Query("SELECT * FROM movements ORDER BY name DESC")
    fun getAll(): List<Movement>

    @Query("SELECT * FROM movements WHERE name LIKE :name")
    fun search(name: String): List<Movement>

    @Delete
    fun delete(movement: Movement)
}