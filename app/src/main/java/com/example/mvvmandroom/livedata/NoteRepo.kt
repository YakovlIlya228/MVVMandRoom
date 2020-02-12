package com.example.mvvmandroom.livedata

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.mvvmandroom.database.DAO
import com.example.mvvmandroom.database.Note
import com.example.mvvmandroom.database.NoteDatabase
import io.reactivex.Single
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NoteRepo(private val noteDao: DAO){
    var allNotes: LiveData<List<Note>> = getNotes()
//    var allNotes: LiveData<List<Note>>? = null
    suspend fun insert(note: Note) =
        withContext(Dispatchers.IO){
        noteDao.insert(note)
    }

    suspend fun update(note: Note) =
        withContext(Dispatchers.IO){
        noteDao.update(note)
    }

    suspend fun delete(note: Note) =
        withContext(Dispatchers.IO){
            noteDao.delete(note)
    }

    suspend fun deleteAll() =
        withContext(Dispatchers.IO){
            noteDao.deleteAll()
        }
    fun getNotes(): LiveData<List<Note>>{
        allNotes = noteDao.getAll()
        return allNotes
    }

}