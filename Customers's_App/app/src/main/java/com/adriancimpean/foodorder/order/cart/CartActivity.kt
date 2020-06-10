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
import com.adriancimpean.foodorder.order.ConfirmOrderActivity
import com.adriancimpean.foodorder.order.Item
import com.adriancimpean.foodorder.order.OrdersActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.json.JSONArray
import org.json.JSONObject

class CartActivity : AppCompatActivity() {

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
            //placeOrder()
            var intent = Intent(this@CartActivity, ConfirmOrderActivity::class.java)
            startActivity(intent)
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


}
