package com.example.contacts.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.contacts.model.Contact
import com.example.contacts.model.Note

@Dao
interface NotesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun  insertNote(note: Note)

    @Query("SELECT * FROM Notes")
    fun getAllNotes(): LiveData<List<Note>>

    @Query("SELECT * FROM Notes WHERE noteId= :noteId")
    fun getNoteById(noteId: Int): LiveData<Note>

    @Delete
    fun deleteNote(note: Note)
}