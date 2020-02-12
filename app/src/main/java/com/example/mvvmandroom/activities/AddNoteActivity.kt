package com.example.mvvmandroom.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmandroom.R
import com.example.mvvmandroom.database.Note
import com.example.mvvmandroom.livedata.NoteViewModel
import kotlinx.android.synthetic.main.activity_add_note.*

class AddNoteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)
        val bundle: Bundle? = intent.getBundleExtra("note")
        val viewModel: NoteViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)
        priorityPicker.minValue = 1
        priorityPicker.maxValue = 10
        if(bundle!=null){
            titleEdit.setText(bundle.getString("title"))
            descriptionEdit.setText(bundle.getString("description"))
            priorityPicker.value = bundle.getInt("priority")
        }
        saveButton.setOnClickListener {
            if(bundle!=null){
                val note = Note(bundle.getInt("noteID"),titleEdit.text.toString(),descriptionEdit.text.toString(),priorityPicker.value)
                viewModel.update(note)
                val returnIntent = Intent(this@AddNoteActivity, MainActivity::class.java)
                startActivity(returnIntent)
            }
            else{
                val note = Note(0,titleEdit.text.toString(),descriptionEdit.text.toString(),priorityPicker.value)
                viewModel.insert(note)
                val returnIntent =  Intent(this@AddNoteActivity, MainActivity::class.java)
                startActivity(returnIntent)

            }
        }
}
}
