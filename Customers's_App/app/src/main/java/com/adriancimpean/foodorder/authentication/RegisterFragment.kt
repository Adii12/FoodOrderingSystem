package com.adriancimpean.foodorder.authentication

import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

import com.adriancimpean.foodorder.R
import com.adriancimpean.foodorder.connection.FetchData
import org.json.JSONObject

/**
 * A simple [Fragment] subclass.
 */
class RegisterFragment : Fragment() {
    val RESPONSE_OK = "200"

    private var registerButton : Button? = null
    private var firstNameText : EditText? = null
    private var lastNameText : EditText? = null
    private var usernameText : EditText? = null
    private var passwordText : EditText? = null
    private var confirmPasswordText : EditText? = null
    private var phoneNoText : EditText? = null
    private var cityText : EditText? = null
    private var countyText : EditText? = null
    private var streetNameText : EditText? = null
    private var streetNoText : EditText? = null

    var user : JSONObject? = null

    inner class registerUser : AsyncTask<Void, Void, String>(){
        override fun doInBackground(vararg p0: Void?): String {
            return FetchData.postRequest("https://food-order-bbcce.firebaseio.com/Users.json", user!!)
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            if(result != RESPONSE_OK)
                Toast.makeText(context,"Error registering user", Toast.LENGTH_SHORT).show()
            else{
                Toast.makeText(context,"Successfully Registered!", Toast.LENGTH_SHORT).show()

            }
        }
    }


    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_register, container, false)

        firstNameText=view.findViewById(R.id.nameText)
        lastNameText=view.findViewById(R.id.lastnameText)
        usernameText=view.findViewById(R.id.usernameText)
        passwordText=view.findViewById(R.id.passwordText)
        confirmPasswordText=view.findViewById(R.id.confirmPasswordText)
        phoneNoText=view.findViewById(R.id.phoneNoText)
        cityText=view.findViewById(R.id.cityText)
        countyText=view.findViewById(R.id.countyText)
        streetNameText=view.findViewById(R.id.streetNoText)
        streetNoText=view.findViewById(R.id.streetNoText)
        registerButton=view.findViewById(R.id.registerButton)

        registerButton!!.setOnClickListener {
            if (validateInput()) {
                user = JSONObject()
                user!!.put("first name", firstNameText!!.text.toString())
                user!!.put("last name", lastNameText!!.text.toString())
                user!!.put("username", usernameText!!.text.toString())
                user!!.put("password", passwordText!!.text.toString())
                user!!.put("phone number", phoneNoText!!.text.toString())
                user!!.put("city", cityText!!.text.toString())
                user!!.put("county", countyText!!.text.toString())
                user!!.put("street", streetNameText!!.text.toString())
                user!!.put("number", streetNoText!!.text.toString())

                val registerUser = registerUser()
                registerUser.execute()
            }
        }
        return view
    }

    private fun validateInput() : Boolean{
        //TODO: VALIDATE INPUT

        if(firstNameText!!.text.toString()=="") {
            Toast.makeText(context, "Please fill in all boxes", Toast.LENGTH_SHORT).show()
            return false
        }
        if(passwordText!!.text.toString() != confirmPasswordText!!.text.toString()){
            Toast.makeText(context, "Passwords do not match", Toast.LENGTH_SHORT).show()
            return false
        }
        if(phoneNoText!!.text.toString().length!=10) {
            Toast.makeText(context, "Invalid phone number", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }


}
