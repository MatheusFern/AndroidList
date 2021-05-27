package com.example.listviewexamples

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.listviewexamples.databinding.ActivityAddNoteActivyBinding
import com.example.listviewexamples.databinding.ActivityMainBinding
import com.example.listviewexamples.model.Note

class AddNoteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddNoteActivyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note_activy)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_add_note, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId)  {
        R.id.menu_add_ic_note -> {
            val title = binding.addNoteTitle.text.toString()
            val description = binding.addNoteDescription.text.toString()

            val note = Note(title, description)
            val returnIntent = Intent (this, MainActivity::class.java)
            returnIntent.putExtra(MainActivity.MAIN_ACTIVITY_NOTE_EXTRA, note)
            setResult(Activity.RESULT_OK, returnIntent)
            finish()
            true

        } else -> {
            //
             super.onOptionsItemSelected(item)
        }

    }
}