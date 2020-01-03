package com.example.mvvmandroom.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Note::class), version = 1)
abstract class noteDatabase : RoomDatabase() {
    abstract fun noteDao(): DAO

    companion object {
        var INSTANCE: noteDatabase? = null

        fun getInstance(context: Context): noteDatabase? {
            if (INSTANCE == null){
                synchronized(noteDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext, noteDatabase::class.java, "noteDB").build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance(){
            INSTANCE = null
        }
    }
}