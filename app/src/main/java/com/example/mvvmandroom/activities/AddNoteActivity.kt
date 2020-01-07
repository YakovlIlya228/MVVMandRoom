package com.example.mvvmandroom.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmandroom.R
import com.example.mvvmandroom.database.Note
import com.example.mvvmandroom.livedata.NoteViewModel
import kotlinx.android.synthetic.main.activity_add_note.*

class AddNoteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)
//        val titleEdit = titleEdit
//        val descriptionEdit = descriptionEdit
//        val priorityPicker = priorityPicker
        val bundle: Bundle? = intent.getBundleExtra("note")
        val viewModel: NoteViewModel? = ViewModelProviders.of(this)[NoteViewModel::class.java]
        if(bundle!=null){
            titleEdit.setText(bundle?.getString("title"))
            descriptionEdit.setText(bundle?.getString("description"))
            priorityPicker.minValue = 1
            priorityPicker.maxValue = 10
            priorityPicker.value = bundle!!.getString("priority")!!.toInt()
        }
        saveButton.setOnClickListener {
            val note = Note(titleEdit.text.toString(),descriptionEdit.text.toString(),priorityPicker.value)
            viewModel?.insert(note)
        }
        }
}
