package com.example.mvvmandroom.livedata

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.room.Dao
import com.example.mvvmandroom.database.DAO
import com.example.mvvmandroom.database.Note
import com.example.mvvmandroom.database.noteDatabase

class Repo {
    var noteDao: DAO? = null
    var allNotes: LiveData<List<Note>>? = null

    fun NoteRepo(application: Application){
        var database: noteDatabase? = noteDatabase.getInstance(application)
        noteDao = database?.noteDao()
        allNotes = noteDao?.getAll()
    }

    fun insert(note: Note){

    }

    fun update(note: Note){

    }

    fun delete(note: Note){

    }

    fun deleteAll(){

    }

    fun getAll(): LiveData<List<Note>>?{
        return allNotes
    }
}