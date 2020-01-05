package com.example.mvvmandroom.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmandroom.R
import com.example.mvvmandroom.database.Note

class NoteAdapter(noteList: List<Note>): RecyclerView.Adapter<NoteAdapter.NoteHolder>() {
    var itemList: List<Note> = noteList
    inner class NoteHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val noteTitle: TextView = itemView.findViewById(R.id.noteTitle)
        val noteDescription: TextView = itemView.findViewById(R.id.noteDescription)
        val priority: TextView = itemView.findViewById(R.id.notePriority)
        fun NoteHolder(){}
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteHolder {
        val itemView = LayoutInflater.from(parent?.context).inflate(R.layout.note_adapter_item,parent,false)
        return NoteHolder(itemView)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: NoteHolder, position: Int) {
        holder?.noteTitle?.text = itemList[position].title
        holder?.noteDescription?.text = itemList[position].description
        holder?.priority?.text = itemList[position].priority.toString()

    }
}