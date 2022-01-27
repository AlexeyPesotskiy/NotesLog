package com.alexey.notes_log

import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alexey.notes_log.recycler.NoteAdapter
import com.alexey.notes_log.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var receiver: NotesReceiver
    private lateinit var adapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = NoteAdapter()
        binding.listNotes.adapter = adapter

        receiver = NotesReceiver(adapter)
        registerReceiver(receiver, IntentFilter(ACTION))
    }

    override fun onDestroy() {
        super.onDestroy()

        unregisterReceiver(receiver)
    }

    companion object {
        const val ACTION = "com.alexey.notes.action_saving"
    }
}