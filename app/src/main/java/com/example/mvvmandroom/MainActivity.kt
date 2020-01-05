package com.example.mvvmandroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmandroom.adapters.NoteAdapter
import com.example.mvvmandroom.database.Note
import com.example.mvvmandroom.livedata.NoteViewModel

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var noteRecycler: RecyclerView = findViewById(R.id.noteRecycler)
        noteRecycler.layoutManager = LinearLayoutManager(this)
        var viewModel: NoteViewModel? = ViewModelProviders.of(this)[NoteViewModel::class.java]
        viewModel?.getAllNotes()?.observe(this, Observer<List<Note>> { allNotes ->
            var noteAdapter = NoteAdapter(allNotes)
            noteRecycler.adapter = noteAdapter
        })
    }
}
