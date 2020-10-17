package com.lennydennis.notebook.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.lennydennis.notebook.R
import com.lennydennis.notebook.data.DataManager
import com.lennydennis.notebook.databinding.FragmentNoteListBinding
import com.lennydennis.notebook.model.NoteInfo
import com.lennydennis.notebook.ui.adapters.NotesAdapter
import kotlinx.android.synthetic.main.fragment_note_list.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class NoteListFragment : Fragment() {
    private lateinit var noteListBinding: FragmentNoteListBinding
    private val mNotesAdapter = NotesAdapter(DataManager.notes)

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        noteListBinding = FragmentNoteListBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return noteListBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        notes_recyclerView.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = mNotesAdapter
        }

        val addNewNoteButton = view.findViewById<FloatingActionButton>(R.id.add_new_note)
        addNewNoteButton?.setOnClickListener {
            findNavController().navigate(R.id.action_NoteListFragment_to_FirstFragment, null)
        }

        mNotesAdapter.noteClickListener = object : NotesAdapter.NoteClickListener{
            override fun onNoteClicked(notePosition: Int) {
                val action = NoteListFragmentDirections.actionNoteListFragmentToFirstFragment(notePosition)
                findNavController().navigate(action)
            }
        }

    }
}