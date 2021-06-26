package com.example.contacts

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class PhoneContactsAdapter( var contactList: List<Contact>, var context:Context):RecyclerView.Adapter<ContactsViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
       var itemView = LayoutInflater.from(parent.context).inflate(R.layout.phone_book_contacts,parent,false)
        return ContactsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
        var contacts = contactList.get(position)
         holder.tvName.text = contacts.name
        holder.tvPhoneNumber.text = contacts.phoneNumber
        holder.tvEmail.text = contacts.email
        Picasso
            .get()
            .load(contacts.imageUrl)
            .placeholder(R.drawable.person)
            .into(holder.imgContact)
        holder.cvContact.setOnClickListener {
            var intent = Intent(context,ViewContactActivity::class.java)
            intent.putExtra("name",contacts.name)
            intent.putExtra("phoneNumber",contacts.phoneNumber)
            intent.putExtra("email",contacts.email)
            intent.putExtra("image",contacts.imageUrl)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }



    }

    override fun getItemCount(): Int {
       return contactList.size
    }
}
class ContactsViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    var tvName = itemView.findViewById<TextView>(R.id.tvName)
    var tvPhoneNumber = itemView.findViewById<TextView>(R.id.tvPhoneNumber)
    var tvEmail = itemView.findViewById<TextView>(R.id.tvEmail)
    var imgContact = itemView.findViewById<ImageView>(R.id.imgContact)
    var cvContact = itemView.findViewById<CardView>(R.id.cvContact)
}