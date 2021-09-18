
package com.example.contacts.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.AddContactActivity
import com.example.contacts.model.Contact
import com.example.contacts.PhoneContactsAdapter
import com.example.contacts.R
import com.example.contacts.databinding.ActivityAddContactBinding
import com.example.contacts.databinding.ActivityPhonebookBinding
import com.example.contacts.viewmodel.ContactViewModel

class Phonebook : AppCompatActivity() {
    lateinit var binding: ActivityPhonebookBinding
    val contactsViewModel: ContactViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPhonebookBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    override fun onResume() {
        super.onResume()
        contactsViewModel.getAllContacts()
        contactsViewModel.contactLiveData.observe(this,{contacts->
            displayContacts(contacts)
        })
        binding.fbSaveContact.setOnClickListener {
            startActivity(Intent(this,AddContactActivity::class.java))
        }
    }

    fun displayContacts(contactsList: List<Contact>){
        var rvContact = findViewById<RecyclerView>(R.id.rvContacts)//view binding
        rvContact.layoutManager = LinearLayoutManager(baseContext)
        var phoneContactsAdapter = PhoneContactsAdapter(contactsList, baseContext)
        rvContact.adapter = phoneContactsAdapter
    }
}