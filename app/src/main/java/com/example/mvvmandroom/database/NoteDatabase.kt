package com.example.mvvmandroom.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): DAO

    companion object {

        @Volatile
        var INSTANCE: NoteDatabase? = null

        fun getInstance(context: Context): NoteDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(NoteDatabase::class) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NoteDatabase::class.java,
                    "noteDB"
                ).build()
                INSTANCE = instance
                return instance
            }
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}