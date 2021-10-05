package com.example.zouklab.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.zouklab.database.entities.Movement

@Database(version = 1, entities = [Movement::class], exportSchema = false)
abstract class ZoukDatabase: RoomDatabase() {

    abstract val movementDao: MovementDao

    companion object {
        const val DATABASE_NAME = "zouk_db"
        @Volatile
        private var INSTANCE: ZoukDatabase? = null

        fun getInstance(context: Context): ZoukDatabase {
            synchronized(this) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        ZoukDatabase::class.java,
                        DATABASE_NAME)
                        .build()
                }
                return INSTANCE as ZoukDatabase
            }
        }
    }



}