package com.example.contacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Phonebook : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phonebook)
        displayContacts()

    }
    fun displayContacts(){
        var rvContact = findViewById<RecyclerView>(R.id.rvContacts)
        rvContact.layoutManager = LinearLayoutManager(baseContext)

        var contacts = listOf(
            Contact("Hunter Achieng", "0708861088","achienghunter@gmail.com"),
            Contact("Stacy Anyango", "07004234777","anyangostacy@gmail.com"),
            Contact("Shadya Obuya", "0797731088","shadobuy@gmail.com"),
            Contact("Joseph Mwimali", "0734724728","mwimaliJose@gmail.com"),
            Contact("Odongo Charles", "0712359872","charlsodongo@gmail.com"),
            Contact("Susan Owiyo", "0712986545","owiyosusan@gmail.com")
        )

        var phoneContactsAdapter = PhoneContactsAdapter(contacts)
        rvContact.adapter = phoneContactsAdapter
    }
}