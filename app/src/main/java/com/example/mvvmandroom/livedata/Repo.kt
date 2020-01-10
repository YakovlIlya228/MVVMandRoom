package com.example.mvvmandroom.livedata

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.mvvmandroom.database.DAO
import com.example.mvvmandroom.database.Note
import com.example.mvvmandroom.database.noteDatabase
import io.reactivex.Single

class Repo {
    var noteDao: DAO? = null
    var allNotes: LiveData<List<Note>>? = null

    fun NoteRepo(application: Application){
        var database: noteDatabase? = noteDatabase.getInstance(application)
        noteDao = database?.noteDao()
        allNotes = noteDao?.getAll()
    }

    fun insert(noteDAO: DAO?, note: Note): Single<Unit>{
        return Single.create {
            noteDAO!!.insert(note)
        }
    }

    fun update(noteDAO: DAO?,note: Note): Single<Unit>{
        return Single.create {
            noteDAO!!.update(note)
        }
    }

    fun delete(noteDAO: DAO?, note: Note): Single<Unit>{
        return Single.create {
            noteDAO!!.delete(note)
        }
    }

    fun deleteAll(): Single<Unit>{
        return Single.create {
            noteDao!!.deleteAll()
        }
    }

    fun getAll(): LiveData<List<Note>>?{
        return allNotes
    }

}