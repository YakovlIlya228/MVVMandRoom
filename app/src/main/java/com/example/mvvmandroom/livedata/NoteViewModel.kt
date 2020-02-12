package com.example.mvvmandroom.livedata

import android.app.Application
import androidx.lifecycle.*
import com.example.mvvmandroom.database.Note
import com.example.mvvmandroom.database.NoteDatabase
import kotlinx.coroutines.launch

class NoteViewModel(application: Application): AndroidViewModel(application) {
//    val notes: MutableLiveData<List<Note>> by lazy {
//        MutableLiveData<List<Note>>().also{
//            loadNotes()
//        }
//    }
    val notes: LiveData<List<Note>>
    private val noteRepository: NoteRepo
    init {
        val noteDao = NoteDatabase.getInstance(application).noteDao()
        noteRepository = NoteRepo(noteDao)
        notes = noteRepository.allNotes
    }


//    private fun loadNotes()= viewModelScope.launch{
//        noteRepository.getNotes()
//    }

    fun insert(note: Note) = viewModelScope.launch{
        noteRepository.insert(note)
    }

    fun update(note: Note) = viewModelScope.launch{
        noteRepository.update(note)
    }

    fun delete(note: Note)= viewModelScope.launch{
        noteRepository.delete(note)
    }
    fun deleteAll() = viewModelScope.launch{
        noteRepository.deleteAll()
    }
}