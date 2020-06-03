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
import com.adriancimpean.foodorder.R
import com.adriancimpean.foodorder.connection.FetchData
import com.adriancimpean.foodorder.menu.MainActivity
import com.adriancimpean.foodorder.order.cart.Cart
import kotlinx.android.synthetic.main.fragment_login.*
import org.json.JSONObject

/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : Fragment() {

    var data: JSONObject? = null    //for storing json which came from firebase
    var parse : getUsers? = null

    @SuppressLint("StaticFieldLeak")
    inner class getUsers : AsyncTask<Void, Void, String>() {
        override fun doInBackground(vararg p0: Void?): String {
            return FetchData.getRequest("https://food-order-bbcce.firebaseio.com/Users.json")
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            data = JSONObject(result)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_login, container, false)
        val loginBtn: Button = view.findViewById(R.id.LoginButton)
        val usernameText = view.findViewById(R.id.usernameText) as EditText
        val passwordText = view.findViewById(R.id.passwordText) as EditText

        Cart.resetCart()

        parse = getUsers()
        parse!!.execute()

        loginBtn.setOnClickListener {
            var task = getUsers()
            task.execute()
            if(validateInput()) {
                login(usernameText, passwordText)
            }
        }
        return view;
    }

    private fun login(usernameText: EditText, passwordText: EditText) {
        var dataArr = data!!.toJSONArray(data!!.names())
        var loginOk = false

        for (i in 0 until dataArr!!.length()) {
            var username = dataArr.getJSONObject(i).get("username").toString()
            var password = dataArr.getJSONObject(i).get("password").toString()
            println(username)
            println(password)
            loginOk = false

            if (username == usernameText.text.toString() && password == passwordText.text.toString()) {
                loginOk = true
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
}
