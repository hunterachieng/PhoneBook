package com.example.contacts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PhoneContactsAdapter( var contactList: List<Contact>):RecyclerView.Adapter<ContactsViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
       var itemView = LayoutInflater.from(parent.context).inflate(R.layout.phone_book_contacts,parent,false)
        return ContactsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
        var contacts = contactList.get(position)
         holder.tvName.text = contacts.name
        holder.tvPhoneNumber.text = contacts.phoneNumber
        holder.tvEmail.text = contacts.email



    }

    override fun getItemCount(): Int {
       return contactList.size
    }
}
class ContactsViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    var tvName = itemView.findViewById<TextView>(R.id.tvName)
    var tvPhoneNumber = itemView.findViewById<TextView>(R.id.tvPhoneNumber)
    var tvEmail = itemView.findViewById<TextView>(R.id.tvEmail)
}