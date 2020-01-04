package com.example.mvvmandroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmandroom.database.Note
import com.example.mvvmandroom.livedata.NoteViewModel
import com.example.mvvmandroom.livedata.Repo

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var viewModel: NoteViewModel? = ViewModelProviders.of(this)[NoteViewModel::class.java]
        viewModel?.getAllNotes()?.observe(this, Observer<List<Note>> {
            Toast.makeText(applicationContext, "Data fetched!", Toast.LENGTH_LONG).show()
        })
    }
}
