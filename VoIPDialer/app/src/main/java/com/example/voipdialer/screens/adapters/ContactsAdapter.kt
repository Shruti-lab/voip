package com.example.voipdialer.screens.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.voipdialer.R
import com.example.voipdialer.data.Contact

class ContactsAdapter(private val contactsList: List<Contact>, private val onCallClicked: (Contact) -> Unit) : RecyclerView.Adapter<ContactsAdapter.ContactViewHolder>() {

    class ContactViewHolder(view: View): RecyclerView.ViewHolder(view){
        val contactName: TextView
        val callButton: Button

        init {
            // Define click listener for the ViewHolder's View
            contactName = view.findViewById(R.id.contactName)
            callButton = view.findViewById(R.id.call_button)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_row_item, parent, false)

        return ContactViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val contact = contactsList[position]
        holder.contactName.text = contact.name
        holder.callButton.setOnClickListener {
            onCallClicked(contact)
        }
    }

    override fun getItemCount(): Int {
        return contactsList.size
    }
}