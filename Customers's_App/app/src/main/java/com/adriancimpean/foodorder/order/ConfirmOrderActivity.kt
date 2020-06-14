package com.adriancimpean.foodorder.order

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.adriancimpean.foodorder.CurrentUser
import com.adriancimpean.foodorder.R
import com.adriancimpean.foodorder.connection.ConnectionHandler
import com.adriancimpean.foodorder.order.cart.Cart
import com.adriancimpean.foodorder.order.cart.CartListAdapter
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_confirm_order.*
import org.json.JSONArray
import org.json.JSONObject
import java.net.ConnectException

class ConfirmOrderActivity : AppCompatActivity() {
    private val RESPONSE_OK = "200"

    private var orderListView : ListView? = null
    private var cityEditText : EditText? = null
    private var countyEditText : EditText? = null
    private var streetNameEditText : EditText? = null
    private var streetNoEditText : EditText? = null
    private var phoneNoText : EditText? = null
    private var sendButton : Button? = null
    private var cancelButton : Button? = null

    private var listItems : ArrayList<Item>? = null
    private var adapter : CartListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm_order)

        orderListView = findViewById(R.id.orderList)
        cityEditText = findViewById(R.id.cityEditText)
        countyEditText = findViewById(R.id.countyEditText)
        streetNameEditText = findViewById(R.id.streetNameEditText)
        streetNoEditText = findViewById(R.id.streetNumberEditText)
        phoneNoText = findViewById(R.id.phoneNumberEditText)
        sendButton = findViewById(R.id.sendButton)
        cancelButton = findViewById(R.id.cancelButton)

        cityEditText!!.setText(CurrentUser.city)
        countyEditText!!.setText(CurrentUser.county)
        streetNameEditText!!.setText(CurrentUser.streetName)
        streetNoEditText!!.setText(CurrentUser.streetNo)
        phoneNoText!!.setText(CurrentUser.phoneNo)

        listItems= Cart.getCart()

        adapter = CartListAdapter(this@ConfirmOrderActivity, R.layout.custom_cart_list, listItems!!)

        orderListView!!.adapter = adapter

        cancelButton!!.setOnClickListener {
            finish()
        }

        sendButton!!.setOnClickListener {
            placeOrder()
        }
    }

    private fun placeOrder(){
        var orderItems = JSONObject()
        var orderArr = JSONArray()

        for(i in 0 until listItems!!.size) {
            orderArr.put(i, listItems!![i].Name.toString())
        }

        orderItems.put("Items", orderArr)
        orderItems.put("first name", CurrentUser.firstName)
        orderItems.put("last name", CurrentUser.lastName)
        orderItems.put("city", cityEditText!!.text.toString())
        orderItems.put("county", countyEditText!!.text.toString())
        orderItems.put("street name", streetNameEditText!!.text.toString())
        orderItems.put("street no", streetNumberEditText!!.text.toString())
        orderItems.put("phone number", phoneNumberEditText!!.text.toString())
        orderItems.put("user id", CurrentUser.user_id)
        orderItems.put("Price", Cart.getTotalPrice().toString())
        orderItems.put("status", "Pending")

        if(ConnectionHandler.isNetworkAvailable(this)) {
            var sendOrder = sendOrder()
            sendOrder.execute(orderItems)
        } else {
            Snackbar.make(window.decorView.rootView, R.string.no_internet, Snackbar.LENGTH_SHORT).show()
        }
    }

    inner class sendOrder : AsyncTask<JSONObject, Void, String>(){
        override fun doInBackground(vararg jobj: JSONObject?): String {
            return ConnectionHandler.postRequest("https://food-order-bbcce.firebaseio.com/Orders.json", jobj[0]!!)
        }

        override fun onPostExecute(result: String?) {
            if(result==RESPONSE_OK) {
                Toast.makeText(this@ConfirmOrderActivity, "Order placed successfully", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this@ConfirmOrderActivity, "Error placing your order", Toast.LENGTH_SHORT).show()
            }
        }
    }
}