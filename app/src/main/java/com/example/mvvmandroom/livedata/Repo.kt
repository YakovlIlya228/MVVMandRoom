package com.example.mvvmandroom.livedata

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
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
        InsertNoteAsync(noteDao).execute(note)
    }

    fun update(note: Note){
        UpdateNoteAsync(noteDao).execute(note)
    }

    fun delete(note: Note){
        DeleteNoteAsync(noteDao).execute(note)
    }

    fun deleteAll(){
        DeleteAllNotesAsync(noteDao).execute()
    }

    fun getAll(): LiveData<List<Note>>?{
        return allNotes
    }

    class InsertNoteAsync(var noteDAO: DAO?): AsyncTask<Note?, Void, Void>() {
        override fun doInBackground(vararg notes: Note?): Void? {
            noteDAO?.insert(notes[0])
            return null
        }
    }

    class UpdateNoteAsync(var noteDAO: DAO?): AsyncTask<Note?, Void, Void>(){
        override fun doInBackground(vararg notes: Note?): Void? {
            noteDAO?.update(notes[0])
            return null
        }
    }

    class DeleteNoteAsync(var noteDAO: DAO?): AsyncTask<Note?, Void, Void>(){
        override fun doInBackground(vararg notes: Note?): Void? {
            noteDAO?.delete(notes[0])
            return null
        }
    }
    class DeleteAllNotesAsync(var noteDAO: DAO?): AsyncTask<Void, Void, Void>(){
        override fun doInBackground(vararg p0: Void?): Void? {
            noteDAO?.deleteAll()
            return null
        }
    }
}