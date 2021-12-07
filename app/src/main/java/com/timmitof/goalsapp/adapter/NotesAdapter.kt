package com.timmitof.goalsapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.timmitof.goalsapp.R
import com.timmitof.goalsapp.models.NotesClass

class NotesAdapter(private var array: ArrayList<NotesClass>) :
    RecyclerView.Adapter<NotesAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleView: TextView = view.findViewById(R.id.item_title)
        val textView: TextView = view.findViewById(R.id.item_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_notes, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = array[position]
        holder.titleView.text = item.text
        holder.textView.text = item.text
    }

    override fun getItemCount(): Int {
        return array.size
    }
}