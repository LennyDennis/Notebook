package com.lennydennis.notebook.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.lennydennis.notebook.model.CourseInfo
import com.lennydennis.notebook.R
import com.lennydennis.notebook.data.DataManager
import kotlinx.android.synthetic.main.fragment_new_note.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class NewNoteFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_note, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapterCourses = ArrayAdapter<CourseInfo>(requireContext(),
            android.R.layout.simple_spinner_item,
            DataManager.courses.values.toList())

        adapterCourses.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        course_spinner.adapter = adapterCourses;


    }
}