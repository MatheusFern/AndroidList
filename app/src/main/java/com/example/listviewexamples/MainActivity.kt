package com.example.listviewexamples

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listviewexamples.databinding.ActivityMainBinding
import com.example.listviewexamples.model.Note

class MainActivity : AppCompatActivity() {

    private lateinit var notes:MutableList<Note>

    private val mNoteAdapter by lazy { NoteRecyclerAdapter( notes) }
    private lateinit var binding: ActivityMainBinding

    companion object {
        const val MAIN_ACTIVITY_NOTE_EXTRA = "note_extra"
        const val MAIN_ACTIVITY_REQUEST_CODE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initNotes()
        setupRecyclerView()

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            if (requestCode == MAIN_ACTIVITY_REQUEST_CODE) {
                val note = data?.getParcelableExtra<Note>(MAIN_ACTIVITY_NOTE_EXTRA)
                note?.let { notes.add(it) }
                mNoteAdapter.notifyDataSetChanged()
            }
        }
    }

    private fun initNotes() {
        notes = mutableListOf()
        for (i in 1..5) {
            var note = Note("note$i", "note description $i inserted")
            notes.add(note)
        }
    }

    private fun setupRecyclerView() {
        binding.noteList.adapter = mNoteAdapter
        val layoutManager = LinearLayoutManager(this)
        binding.noteList.layoutManager = layoutManager
    }

    fun setupButton(view: View) {
        binding.Addnote.setOnClickListener {
            val intent = Intent(this, AddNoteActivity::class.java)
            startActivityForResult(intent, MAIN_ACTIVITY_REQUEST_CODE)
        }
    }
}