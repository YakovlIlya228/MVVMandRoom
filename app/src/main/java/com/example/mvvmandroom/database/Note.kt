package com.example.mvvmandroom.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "note_table")
data class Note(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name="title") var title: String,
    @ColumnInfo(name="description") var description: String?,
    @ColumnInfo(name="priority") var priority: Int
){
    constructor(title: String,description: String?,priority: Int): this(Int.MIN_VALUE,title,description,priority)
}