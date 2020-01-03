package com.example.mvvmandroom.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DAO{
    @Query("SELECT * FROM  note_table ORDER BY id ASC")
    fun getAll(): LiveData<List<Note>>

    @Insert
    fun insertAll(vararg note: Note)

    @Update
    fun updateAll(vararg note: Note)

    @Insert
    fun insert(note: Note?)

    @Update
    fun update(note: Note?)

    @Delete
    fun delete(note: Note?)

    @Query("DELETE FROM note_table")
    fun deleteAll()

//    @Query("SELECT * FROM note_table WHERE id IN (:noteIDs)")
//    fun loadAllByIDs(noteIDs: IntArray): List<Note>

    @Query("SELECT * FROM note_table WHERE title LIKE :this_title")
    fun findByTitle(this_title: String): Note
}