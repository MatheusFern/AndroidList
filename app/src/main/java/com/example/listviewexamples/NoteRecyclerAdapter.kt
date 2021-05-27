package com.example.listviewexamples


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listviewexamples.databinding.NoteItemBinding
import com.example.listviewexamples.model.Note

class NoteRecyclerAdapter (private val notes:MutableList<Note>)
    : RecyclerView.Adapter<NoteRecyclerAdapter.VH>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        val binding = NoteItemBinding.bind(view)

        val vh = VH(binding)
        return vh
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
     val note = notes[position]
     holder.setValues( note.title, note.description )
    }

    override fun getItemCount() = notes.size

    class VH (itemView: NoteItemBinding) : RecyclerView.ViewHolder(itemView.root){
        private val title = itemView.noteItemTitle
        private val description = itemView.itemNoteDescription

        fun setValues(title: String, description: String) {
            this.title.text = title
            this.description.text = description
        }
    }
}