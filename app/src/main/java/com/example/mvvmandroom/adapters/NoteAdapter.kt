package com.example.mvvmandroom.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmandroom.R
import com.example.mvvmandroom.database.Note
import kotlinx.android.synthetic.main.note_adapter_item.view.*

class NoteAdapter(noteList: List<Note>): RecyclerView.Adapter<NoteAdapter.NoteHolder>() {
    var itemList: List<Note> = noteList
//    var onItemClick: ((Note) -> Unit)? = null
    inner class NoteHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val noteTitle: TextView = itemView.noteTitle
        val noteDescription: TextView = itemView.noteDescription
        val priority: TextView = itemView.notePriority
//        init {
//            itemView.setOnClickListener {
//                onItemClick?.invoke(itemList[adapterPosition])
//            }
//        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteHolder {
        val itemView = LayoutInflater.from(parent?.context).inflate(R.layout.note_adapter_item,parent,false)
        return NoteHolder(itemView)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: NoteHolder, position: Int) {
        val item = itemList[position]
        holder?.noteTitle?.text = item.title
        holder?.noteDescription?.text = item.description
        holder?.priority?.text = item.priority.toString()
    }
}