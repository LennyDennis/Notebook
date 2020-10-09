package com.lennydennis.notebook.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.lennydennis.notebook.databinding.NoteItemBinding
import com.lennydennis.notebook.model.NoteInfo

class NotesAdapter(private val notesList: MutableList<NoteInfo>) : RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {

    lateinit var noteClickListener: NoteClickListener

    interface NoteClickListener {
        fun onNoteClicked(noteTitle: String, noteText: String)
    }

    inner class NotesViewHolder(val binding: NoteItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(notes: NoteInfo) {
            binding.tvNoteTitle.text = notes.title
            binding.tvNoteText.text = notes.text
            binding.noteDisplay.setOnClickListener {
                noteClickListener.onNoteClicked(
                    notes.title,
                    notes.text
                )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val noteItemBinding = NoteItemBinding.inflate(
            layoutInflater,
            parent,
            false
        )
        return NotesViewHolder(noteItemBinding)
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val movie = notesList[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int {
        return notesList.size
    }


}