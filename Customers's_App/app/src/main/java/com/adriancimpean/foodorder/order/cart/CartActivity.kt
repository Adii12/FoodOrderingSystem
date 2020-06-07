package com.adriancimpean.foodorder.order.cart

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import com.adriancimpean.foodorder.CurrentUser
import com.adriancimpean.foodorder.R
import com.adriancimpean.foodorder.authentication.AuthenticationActivity
import com.adriancimpean.foodorder.connection.FetchData
import com.adriancimpean.foodorder.menu.ItemListAdapter
import com.adriancimpean.foodorder.menu.MainActivity
import com.adriancimpean.foodorder.order.Item
import com.adriancimpean.foodorder.order.OrdersActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.json.JSONArray
import org.json.JSONObject

class CartActivity : AppCompatActivity() {

    private val RESPONSE_OK = "200"

    private var bottomNav : BottomNavigationView? = null
    private var cartItems : ArrayList<Item>? = null
    private var cartListView : ListView? = null
    private var listAdapter : CartListAdapter? = null
    private var totalCost : TextView? = null
    private var sendOrderButton : FloatingActionButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
        cartListView = findViewById(R.id.cartItemsList)
        totalCost = findViewById(R.id.totalPrice)
        sendOrderButton = findViewById(R.id.sendOrderButton)

        cartItems = Cart.getCart()

        listAdapter = CartListAdapter(this, R.layout.custom_cart_list, cartItems!!)
        cartListView!!.adapter = listAdapter

        totalCost?.text ="Total: " + Cart.getTotalPrice().toString() + " RON"
        listAdapter?.notifyDataSetChanged()

        sendOrderButton!!.setOnClickListener {
            placeOrder()
        }

        bottomNav=findViewById(R.id.bottomNav)
        bottomNav!!.selectedItemId = R.id.Cart

        bottomNav!!.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.Menu -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    overridePendingTransition(0,0)
                }

                R.id.Orders -> {
                    startActivity(Intent(this, OrdersActivity::class.java))
                    overridePendingTransition(0,0)
                }

                R.id.LogOut -> {
                    startActivity(Intent(this, AuthenticationActivity::class.java))
                    overridePendingTransition(0,0)
                }
            }
            true

        }
    }

    private fun placeOrder(){
        var orderItems = JSONObject()
        var orderArr = JSONArray()

        for(i in 0 until cartItems!!.size) {
            orderArr.put(i, cartItems!![i].Name.toString())
        }

        orderItems.put("Items", orderArr)
        orderItems.put("first name", CurrentUser.firstName)
        orderItems.put("last name", CurrentUser.lastName)
        orderItems.put("city", CurrentUser.city)
        orderItems.put("county", CurrentUser.county)
        orderItems.put("street name", CurrentUser.streetName)
        orderItems.put("street no", CurrentUser.streetNo)
        orderItems.put("phone number", CurrentUser.phoneNo)
        orderItems.put("user id", CurrentUser.user_id)
        orderItems.put("Price", Cart.getTotalPrice().toString())
        orderItems.put("status", "Pending")

        println(orderItems)
        var sendOrder = sendOrder()
        sendOrder.execute(orderItems)
    }

    inner class sendOrder : AsyncTask <JSONObject, Void, String>(){
        override fun doInBackground(vararg jobj: JSONObject?): String {
            return FetchData.postRequest("https://food-order-bbcce.firebaseio.com/Orders.json", jobj[0]!!)
        }

        override fun onPostExecute(result: String?) {
            if(result==RESPONSE_OK) {
                Toast.makeText(this@CartActivity, "Order placed successfully", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this@CartActivity, "Error placing your order", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
