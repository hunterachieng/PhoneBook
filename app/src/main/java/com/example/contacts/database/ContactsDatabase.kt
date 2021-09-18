package com.example.contacts.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.contacts.model.Contact
import com.example.contacts.model.Note

@Database(entities = arrayOf(Contact::class, Note::class), version = 1)
abstract class ContactsDatabase: RoomDatabase(){
    abstract fun contactDao():ContactDao
    abstract fun notesDao(): NotesDao
    //companion object do not need to create an instance to access the object
    //object available to all instances of the class. Does not change when instances are created

    companion object {
        private var database: ContactsDatabase? = null

        fun getDatabase(context: Context): ContactsDatabase {
            if (database == null) {
                database =
                    Room.databaseBuilder(context, ContactsDatabase::class.java, "contactDb")
                        .fallbackToDestructiveMigration().build()

            }
            return database as ContactsDatabase
        }

    }
}