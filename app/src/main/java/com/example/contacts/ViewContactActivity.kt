package com.example.contacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class ViewContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_contact)
        var tvName2 = findViewById<TextView>(R.id.tvName2)
        var tvPhoneNumber = findViewById<TextView>(R.id.tvPhoneNumber2)
        var tvEmail = findViewById<TextView>(R.id.tvEmail2)
        var imgContact2= findViewById<ImageView>(R.id.imgContact2)

        tvName2.text = intent.getStringExtra("name")
        tvPhoneNumber.text = intent.getStringExtra("phoneNumber")
        tvEmail.text= intent.getStringExtra("email")
        var image = intent.getStringExtra("image").toString()
        Picasso.get().load(image).into(imgContact2)





    }
}