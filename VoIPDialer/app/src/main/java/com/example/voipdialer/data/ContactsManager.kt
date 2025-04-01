package com.example.voipdialer.data
import com.example.voipdialer.R
import android.content.res.Resources

//generates a list of Contact objects
fun ContactsManager(resources: Resources): List<Contact> {
    return listOf(
        Contact(
            id = 1,
            name = resources.getString(R.string.contact1),

        ),
        Contact(
            id = 2,
            name = resources.getString(R.string.contact2),

            ),

        )
}