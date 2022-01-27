package com.alexey.notes_log.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alexey.notes_log.R
import com.alexey.notes_log.databinding.NoteItemBinding

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteHolder>() {

    private val noteList = ArrayList<String>(0)

    class NoteHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = NoteItemBinding.bind(item)

        fun bind(note: String) = with(binding) {
            noteInfo.text = note
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        return NoteHolder(view)
    }

    override fun onBindViewHolder(holder: NoteHolder, position: Int) {
        holder.bind(noteList[position])
    }

    override fun getItemCount(): Int = noteList.size

    fun addNote(noteInfo: String) {
        noteList.add(noteInfo)
        notifyItemInserted(noteList.size - 1)
    }
}