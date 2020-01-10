package com.example.mvvmandroom.livedata

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.mvvmandroom.database.Note
import com.example.mvvmandroom.database.noteDatabase

class NoteViewModel(application: Application): AndroidViewModel(application) {
    var notes: LiveData<List<Note>>? = Repo().getAll()
    var database: noteDatabase? = noteDatabase.getInstance(application)
    var noteDao = database?.noteDao()

    fun insert(note: Note){
        Repo().insert(noteDao, note)
    }
    fun update(note: Note){
        Repo().update(noteDao, note)
    }
    fun delete(note: Note){
        Repo().delete(noteDao, note)
    }
    fun deleteAll(){
        Repo().deleteAll()
    }

    fun getAllNotes(): LiveData<List<Note>>?{
        return notes
    }
}