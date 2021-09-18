package com.example.contacts.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import com.example.contacts.R
import com.example.contacts.databinding.ActivityViewContactBinding
import com.example.contacts.viewmodel.ContactViewModel
import com.squareup.picasso.Picasso

class ViewContactActivity : AppCompatActivity() {
    lateinit var binding: ActivityViewContactBinding
    val contactViewModel: ContactViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityViewContactBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        var tvName2 = findViewById<TextView>(R.id.tvName2)
//        var tvPhoneNumber = findViewById<TextView>(R.id.tvPhoneNumber2)
//        var tvEmail = findViewById<TextView>(R.id.tvEmail2)
//        var imgContact2= findViewById<ImageView>(R.id.imgContact2)


//        tvPhoneNumber.text = intent.getStringExtra("phoneNumber")
//        tvEmail.text= intent.getStringExtra("email")
//        var image = intent.getStringExtra("image").toString()
//        Picasso.get().load(image).into(imgContact2)





    }
    override fun onResume() {
        super.onResume()
        var contactId = intent.getIntExtra("contactId",0)
        if (contactId!=null){
            contactViewModel.getContactById(contactId)

        }

    }
}