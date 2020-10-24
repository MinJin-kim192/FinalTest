package com.minjin.test.finalTest.dbModel

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [PlayResult::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun resultDAO(): PlayResultDAO

    companion object {
        private var instance: AppDatabase? = null

        @Synchronized
        fun getInstance(context: Context): AppDatabase? {

            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "database-contacts"
                )
                    .allowMainThreadQueries()
                    .build()
            }

            return instance
        }


    }

}