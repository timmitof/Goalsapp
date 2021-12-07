package com.timmitof.goalsapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.timmitof.goalsapp.R
import com.timmitof.goalsapp.adapter.NotesAdapter
import com.timmitof.goalsapp.models.NotesClass

class CalendarFragment : Fragment() {
    var notesArray = ArrayList<NotesClass>()

    lateinit var recyclerView: RecyclerView
    lateinit var addBtn: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_calendar, container, false)

        addBtn = activity?.findViewById(R.id.addNotes)!!

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireActivity())
        recyclerView.adapter = NotesAdapter(notesArray)

        addBtn.setOnClickListener {
            addNotesDialog()
        }

        return view
    }

    private fun addNotesDialog() {
        val alert = AlertDialog.Builder(requireContext())
        val inflater = layoutInflater.inflate(R.layout.add_notes, null)
        alert.setView(inflater)

        val negativeButton: Button = inflater.findViewById(R.id.cancel)
        val positiveButton: Button = inflater.findViewById(R.id.add)

        val headEditText: EditText = inflater.findViewById(R.id.head)
        val textEditText: EditText = inflater.findViewById(R.id.text)

        val dialog = alert.create()

        negativeButton.setOnClickListener {
            dialog.dismiss()
        }

        positiveButton.setOnClickListener {
            notesArray.add(NotesClass(headEditText.text.toString(), textEditText.text.toString()))

            dialog.dismiss()
        }
        dialog.show()
    }
}