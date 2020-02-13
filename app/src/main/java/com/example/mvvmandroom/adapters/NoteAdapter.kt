package com.example.mvvmandroom.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmandroom.R
import com.example.mvvmandroom.database.Note
import kotlinx.android.synthetic.main.note_adapter_item.view.*

class NoteAdapter(context: Context): RecyclerView.Adapter<NoteAdapter.NoteHolder>() {
    private var itemList = emptyList<Note>()
    private val inflater: LayoutInflater = LayoutInflater.from(context)

    inner class NoteHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val noteTitle: TextView = itemView.noteTitle
        val noteDescription: TextView = itemView.noteDescription
        val priority: TextView = itemView.notePriority
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteHolder {
        val itemView = inflater.inflate(R.layout.note_adapter_item,parent,false)
        return NoteHolder(itemView)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun setNotes(notes: List<Note>){
        itemList = notes
        notifyDataSetChanged()
    }

    fun getIdForPos(pos: Int): Int{
        return itemList[pos].id
    }

    override fun onBindViewHolder(holder: NoteHolder, position: Int) {
        val item = itemList[position]
        var id = item.id
        holder.noteTitle.text = item.title
        holder.noteDescription.text = item.description
        holder.priority.text = item.priority.toString()
    }
}