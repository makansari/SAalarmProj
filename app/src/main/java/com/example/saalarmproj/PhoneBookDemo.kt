package com.example.saalarmproj

import android.content.ContentResolver
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Toast
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_second_actvitiy.*
import java.lang.StringBuilder

class PhoneBookDemo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_actvitiy)


        buttonPB.setOnClickListener {
            if(ActivityCompat.checkSelfPermission(
                            this,android.Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED ){
                //getPhoneContacts()

                var phonelist = ArrayList<String>()
                var cresolver : ContentResolver = contentResolver
                var sb = StringBuilder()

                var cursor = cresolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null)
                if(cursor!!.count > 0){
                    while (cursor.moveToNext()){
                       var id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID))
                        val name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
                        sb.append("name is $name")


                        val cursorPhone = contentResolver.query(
                                ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                                null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=?",
                                arrayOf(id), null)
                        if(cursorPhone!!.count > 0 ){

                            while (cursorPhone.moveToNext()){
                                var phNumb =cursorPhone.getString( cursorPhone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)                           )
                                sb.append(" number is $phNumb \n")
                            }
                        }

                        var ph = sb.toString()
                        textViewRes.setText(ph)
                        Toast.makeText(this, "name and number is $ph",Toast.LENGTH_LONG).show()


                    }
                }
                Toast.makeText(this, "PERMISSION GRANTED", Toast.LENGTH_LONG).show()

            }
            else
            {
                ActivityCompat.requestPermissions(this,
                        arrayOf(android.Manifest.permission.READ_CONTACTS),123)
            }



        }


    }
}