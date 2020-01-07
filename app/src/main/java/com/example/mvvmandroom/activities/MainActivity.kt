package com.example.mvvmandroom.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmandroom.R
import com.example.mvvmandroom.adapters.NoteAdapter
import com.example.mvvmandroom.adapters.noteItemListener
import com.example.mvvmandroom.database.Note
import com.example.mvvmandroom.livedata.NoteViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var noteRecycler: RecyclerView = noteRecycler
        noteRecycler.layoutManager = LinearLayoutManager(this)
        var noteAdapter: NoteAdapter? = null
        var viewModel: NoteViewModel? = ViewModelProviders.of(this)[NoteViewModel::class.java]
        viewModel?.getAllNotes()?.observe(this, Observer<List<Note>> { allNotes ->
            noteAdapter = NoteAdapter(allNotes)
            noteRecycler.adapter = noteAdapter
        })
        noteRecycler.addOnItemTouchListener(noteItemListener(noteRecycler,
            object : noteItemListener.OnItemClickListener {
            override fun onItemClick(view: View, position: Int) {
                val addIntent = Intent(this@MainActivity, AddNoteActivity::class.java)
                val bundle = Bundle()
                bundle.putString("title",noteAdapter?.NoteHolder(view)?.noteTitle?.text.toString())
                bundle.putString("description",noteAdapter?.NoteHolder(view)?.noteDescription?.text.toString())
                bundle.putString("priority",noteAdapter?.NoteHolder(view)?.priority?.text.toString())
                addIntent.putExtra("note",bundle)
                startActivity(addIntent)
            }
        }))
    }
}
