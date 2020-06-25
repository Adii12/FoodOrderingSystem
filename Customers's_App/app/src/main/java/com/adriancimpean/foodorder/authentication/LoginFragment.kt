package com.adriancimpean.foodorder.authentication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.adriancimpean.foodorder.CurrentUser
import com.adriancimpean.foodorder.R
import com.adriancimpean.foodorder.connection.ConnectionHandler
import com.adriancimpean.foodorder.menu.MainActivity
import com.adriancimpean.foodorder.order.cart.Cart
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_login.*
import org.json.JSONObject

/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : Fragment() {

    var data: JSONObject? = null    //for storing json which came from firebase
    var parse : getUsers? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_login, container, false)
        val loginBtn: Button = view.findViewById(R.id.LoginButton)
        val usernameText = view.findViewById(R.id.usernameText) as EditText
        val passwordText = view.findViewById(R.id.passwordText) as EditText

        if(ConnectionHandler.isNetworkAvailable(context!!)) {
            parse = getUsers()
            parse!!.execute()
        } else {
            Toast.makeText(context!!, R.string.no_internet, Toast.LENGTH_SHORT).show()
        }

        Cart.resetCart()

        loginBtn.setOnClickListener {
               if(ConnectionHandler.isNetworkAvailable(context!!)) {
                   val task = getUsers()
                   task.execute()

                   if (validateInput()) {
                       login(usernameText, passwordText)
                   }
               }else {
                   Snackbar.make(view, R.string.no_internet, Snackbar.LENGTH_SHORT).show()
               }
        }
        return view;
    }

    private fun login(usernameText: EditText, passwordText: EditText) {
        val dataArr = data!!.toJSONArray(data!!.names())
        var loginOk = false

        for (i in 0 until dataArr!!.length()) {
            val username = dataArr.getJSONObject(i).get("username").toString()
            val password = dataArr.getJSONObject(i).get("password").toString()

            loginOk = false
            if (username == usernameText.text.toString() && password == passwordText.text.toString()) {
                loginOk = true

                val firstName = dataArr.getJSONObject(i).get("first name").toString()
                val lastName = dataArr.getJSONObject(i).get("last name").toString()
                val city = dataArr.getJSONObject(i).get("city").toString()
                val county = dataArr.getJSONObject(i).get("county").toString()
                val streetName = dataArr.getJSONObject(i).get("street").toString()
                val streetNo = dataArr.getJSONObject(i).get("number").toString()
                val phoneNo = dataArr.getJSONObject(i).get("phone number").toString()
                val user_id = data!!.names()!![i]

                CurrentUser.setData(firstName, lastName, username, city, county, streetName, streetNo, phoneNo, user_id as String)
                break
            }
        }

        if (loginOk) {
            val intent = Intent(context, MainActivity::class.java)
            startActivity(intent)

        } else {
            Toast.makeText(context,"Invalid credentials", Toast.LENGTH_LONG).show()
        }
    }

    private fun validateInput() : Boolean{
        if(usernameText.text.toString() == "" && passwordText.text.toString() == ""){
            Toast.makeText(context,"Please fill in all boxes", Toast.LENGTH_LONG).show()
            return false
        }
        return true
    }

    inner class getUsers : AsyncTask<Void, Void, String>() {
        override fun doInBackground(vararg p0: Void?): String {
            return ConnectionHandler.getRequest("https://food-order-bbcce.firebaseio.com/Users.json")
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            data = JSONObject(result)
        }
    }

}
