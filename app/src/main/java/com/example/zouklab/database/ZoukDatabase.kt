package com.example.zouklab.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.zouklab.database.entities.Movement

@Database(version = 1, entities = [Movement::class])
abstract class MovementDatabase: RoomDatabase() {
    abstract fun movementDatabaseDao(): MovementDao
}