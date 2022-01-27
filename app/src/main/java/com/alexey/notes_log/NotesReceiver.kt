package com.alexey.notes_log

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.alexey.notes_log.recycler.NoteAdapter

class NotesReceiver(private val adapter: NoteAdapter) : BroadcastReceiver() {

    /**
     * Обработка полученного широковещательного интента
     */
    override fun onReceive(context: Context, intent: Intent) = with(intent) {
        adapter.addNote(getStringExtra(NOTE_INFO) ?: "")
    }

    companion object {
        const val NOTE_INFO = "note_info"
    }
}