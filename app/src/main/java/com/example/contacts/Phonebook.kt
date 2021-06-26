
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
        var rvContact = findViewById<RecyclerView>(R.id.rvContacts)//view binding
        //.placeholder(R.drawable.placeholder)
        rvContact.layoutManager = LinearLayoutManager(baseContext)

        var contacts = listOf(
            Contact("Hunter Achieng", "0708861088","achienghunter@gmail.com","https://bit.ly/3gQRiCQ"),
            Contact("Stacy Anyango", "07004234777","anyangostacy@gmail.com", "https://bit.ly/3gQRiCQ"),
            Contact("Shadya Obuya", "0797731088","shadobuy@gmail.com","https://bit.ly/3gQRiCQ"),
            Contact("Joseph Mwimali", "0734724728","mwimaliJose@gmail.com", "https://bit.ly/3gQRiCQ"),
            Contact("Odongo Charles", "0712359872","charlsodongo@gmail.com", "https://bit.ly/3gQRiCQ"),
            Contact("Susan Owiyo", "0712986545","owiyosusan@gmail.com", "https://bit.ly/3gQRiCQ")
        )

        var phoneContactsAdapter = PhoneContactsAdapter(contacts, baseContext)
        rvContact.adapter = phoneContactsAdapter
    }
}