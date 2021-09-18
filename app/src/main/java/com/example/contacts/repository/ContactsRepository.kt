package com.example.contacts.repository

import androidx.lifecycle.LiveData
import com.example.contacts.ContactsApp
import com.example.contacts.database.ContactsDatabase
import com.example.contacts.model.Contact
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ContactsRepository {
    val database = ContactsDatabase.getDatabase(ContactsApp.appContext)

    suspend fun saveContact(contact:Contact){
        withContext(Dispatchers.IO){
            database.contactDao().insertContact(contact)
        }
    }
    fun fetchContacts(): LiveData<List<Contact>>{
        return database.contactDao().getAllContacts()
    }
    fun getContactById(contactId:Int): LiveData<Contact>{
        return database.contactDao().getContactById(contactId)

    }
}