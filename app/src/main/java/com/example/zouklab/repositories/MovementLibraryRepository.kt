package com.example.zouklab.repositories

import android.content.Context
import com.example.zouklab.database.MovementDao
import com.example.zouklab.database.ZoukDatabase

abstract class MovementLibraryRepository {
    
    companion object {
        private var movementDao: MovementDao? = null
        @Volatile
        private var INSTANCE: MovementLibraryRepository? = null
        fun getInstance(context: Context): MovementLibraryRepository {
            synchronized(this) {
                if (INSTANCE == null) {
                    movementDao = ZoukDatabase.getInstance(context).movementDao
                    INSTANCE = getInstance(context)
                }
                return INSTANCE as MovementLibraryRepository
            }
        }
    }

}