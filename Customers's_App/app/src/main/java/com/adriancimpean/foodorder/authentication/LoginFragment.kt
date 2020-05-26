package com.adriancimpean.foodorder.authentication

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.adriancimpean.foodorder.menu.MainActivity

import com.adriancimpean.foodorder.R
import com.google.firebase.database.*

/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : Fragment() {

    private fun login(){
        val intent = Intent(context, MainActivity::class.java)
        startActivity(intent)
    }


    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view : View = inflater.inflate(R.layout.fragment_login, container, false)
        val loginBtn : Button = view.findViewById(R.id.LoginButton)

        loginBtn.setOnClickListener{
            login()
        }

        database= FirebaseDatabase.getInstance()
        rootRef=database.reference
        usersRef=rootRef.child("Users")

        usersRef.addValueEventListener(object: ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
                TODO("Not yet implemented")
            }

            override fun onDataChange(p0: DataSnapshot) {
                var value:String =p0.value.toString()
                println(value)
            }
        })

        return view;
    }
    private lateinit var database:FirebaseDatabase
    private lateinit var rootRef: DatabaseReference
    private lateinit var usersRef : DatabaseReference
}
