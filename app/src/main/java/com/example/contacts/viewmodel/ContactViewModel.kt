package com.example.contacts.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contacts.model.Contact
import com.example.contacts.repository.ContactsRepository
import kotlinx.coroutines.launch

class ContactViewModel:ViewModel(){
    val contactsRepository = ContactsRepository()
    lateinit var contactLiveData: LiveData<List<Contact>>
    lateinit var contactsLiveData: LiveData<Contact>

    fun saveContact(contact: Contact){
        viewModelScope.launch {
            contactsRepository.saveContact(contact)
        }
    }
    fun getAllContacts(){
        contactLiveData = contactsRepository.fetchContacts()
    }
    fun getContactById(contactId:Int){
        contactsLiveData = contactsRepository.getContactById(contactId)
    }

}