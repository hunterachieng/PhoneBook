package com.example.contacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.contacts.databinding.ActivityAddContactBinding
import com.example.contacts.model.Contact
import com.example.contacts.viewmodel.ContactViewModel

class AddContactActivity : AppCompatActivity() {
    lateinit var binding:ActivityAddContactBinding
    val contactViewModel: ContactViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddContactBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        binding.btnAddContact.setOnClickListener {

        }
    }
    fun saveContact(){
        var name = binding.etname.text.toString()
        var email = binding.etEmail.text.toString()
        var phoneNumber = binding.etPhoneNumber.text.toString()
        var error = false

        if (name.isEmpty()|| name.isBlank()){
            error = true
            binding.tilName.error = "Name is required"
        }

        if (email.isEmpty()|| email.isBlank()){
            error = true
            binding.tilEmail.error = "Email is required"
        }

        if (phoneNumber.isEmpty()|| phoneNumber.isBlank()){
            error = true
            binding.tilPhone.error = "PhoneNumber is required"
        }

        if (!error){
            var contact = Contact(0,name,phoneNumber,email,"")
            contactViewModel.saveContact(contact)
            binding.etname.setText("")
            binding.etEmail.setText("")
            binding.etPhoneNumber.setText("")
        }
    }
}