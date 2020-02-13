package com.example.mvvmandroom.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmandroom.R
import com.example.mvvmandroom.adapters.NoteAdapter
import com.example.mvvmandroom.adapters.noteItemListener
import com.example.mvvmandroom.database.Note
import com.example.mvvmandroom.livedata.NoteViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
//    val REQUEST_CODE = 10000
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val addButton: FloatingActionButton = addButton
        val noteRecycler: RecyclerView = noteRecycler
        val noteAdapter = NoteAdapter(this)
        noteRecycler.layoutManager = LinearLayoutManager(this)
        noteRecycler.adapter = noteAdapter
        val viewModel: NoteViewModel  = ViewModelProvider(this).get(NoteViewModel::class.java)
        viewModel.notes.observe(this, Observer<List<Note>>{
            it.let { noteAdapter.setNotes(it) }
        })
//        val newNote = Note(0,"Apple","Buy 1 kilo of apples", 5)
//        val notesList = mutableListOf<Note>()
//        notesList.add(newNote)
//        noteAdapter.setNotes(notesList)
        noteRecycler.addOnItemTouchListener(noteItemListener(noteRecycler,
            object : noteItemListener.OnItemClickListener {
            override fun onItemClick(view: View, position: Int) {
                val updateIntent = Intent(this@MainActivity, AddNoteActivity::class.java)
                val bundle = Bundle()
                bundle.putInt("noteID",noteAdapter.getIdForPos(position))
                Log.d("noteidmain",noteAdapter.getIdForPos(position).toString())
                bundle.putString("title",noteRecycler.findViewHolderForAdapterPosition(position)?.itemView?.findViewById<TextView>(R.id.noteTitle)?.text.toString())
                bundle.putString("description",noteAdapter.NoteHolder(view).noteDescription.text.toString())
                bundle.putInt("priority",noteAdapter.NoteHolder(view).priority.text.toString().toInt())
                updateIntent.putExtra("note",bundle)
                startActivity(updateIntent)
            }
        }))
        addButton.setOnClickListener {
            val addIntent = Intent(this@MainActivity, AddNoteActivity::class.java)
            startActivity(addIntent)
        }

    }
}

