package com.example.mvvmandroom.livedata

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.mvvmandroom.database.Note

class NoteViewModel(application: Application): AndroidViewModel(application) {
    var notes: LiveData<List<Note>>? = Repo().getAll()

    fun insert(note: Note){
        Repo().insert(note)
    }
    fun update(note: Note){
        Repo().update(note)
    }
    fun delete(note: Note){
        Repo().delete(note)
    }
    fun deleteAll(){
        Repo().deleteAll()
    }

    fun getAllNotes(): LiveData<List<Note>>?{
        return Repo().allNotes
    }
}