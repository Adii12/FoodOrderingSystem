package com.adriancimpean.foodorder.order

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.ProgressBar
import android.widget.Toast
import com.adriancimpean.foodorder.CurrentUser
import com.adriancimpean.foodorder.R
import com.adriancimpean.foodorder.authentication.AuthenticationActivity
import com.adriancimpean.foodorder.connection.ConnectionHandler
import com.adriancimpean.foodorder.menu.MainActivity
import com.adriancimpean.foodorder.order.cart.CartActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar
import org.json.JSONArray
import org.json.JSONObject


class OrdersActivity : AppCompatActivity() {
    private var bottomNav : BottomNavigationView? = null
    private var ordersList : ListView? = null
    private var listItems : ArrayList<Order>? = null
    private var listAdapter : OrderListAdapter? = null
    private var loader : ProgressBar? = null
    private var orderItems : ArrayList<String>? = null
    var data : JSONObject? = null
    var arrData : JSONArray? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orders)
        bottomNav=findViewById(R.id.bottomNav)
        bottomNav!!.selectedItemId = R.id.Orders
        loader = findViewById(R.id.orderLoader)

        ordersList = findViewById(R.id.ordersList)
        listItems = ArrayList()

        listAdapter = OrderListAdapter(this@OrdersActivity, R.layout.custom_order_list, listItems!!)
        ordersList!!.adapter=listAdapter

        if(ConnectionHandler.isNetworkAvailable(this)) {
            val getUsersOrders = getUsersOrders()
            getUsersOrders.execute()
        } else {
            //Toast.makeText(this, "No internet connection", Toast.LENGTH_SHORT).show()
            Snackbar.make(window.decorView.rootView, R.string.no_internet, Snackbar.LENGTH_SHORT).show()
        }

        bottomNav!!.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.Menu -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    overridePendingTransition(0,0)
                }
                R.id.Cart -> {
                    startActivity(Intent(this, CartActivity::class.java))
                    overridePendingTransition(0,0)
                }
                R.id.LogOut -> {
                    startActivity(Intent(this,  AuthenticationActivity::class.java))
                    overridePendingTransition(0,0)
                }
            }
            true
        }
    }

    inner class getUsersOrders : AsyncTask<Void,Void,String>(){
        override fun onPreExecute() {
            loader!!.visibility = View.VISIBLE
        }

        override fun doInBackground(vararg p0: Void?): String {
            return ConnectionHandler.getRequest("https://food-order-bbcce.firebaseio.com/Orders.json")
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            data = JSONObject(result!!)
            arrData = data!!.toJSONArray(data!!.names())
            orderItems = ArrayList()

            for(i in 0 until arrData!!.length()){
                var orderUserID = arrData!!.getJSONObject(i).get("user id")
                println(orderUserID)
                if(orderUserID == CurrentUser.user_id){
                    for(j in 0 until arrData!!.getJSONObject(i).getJSONArray("Items").length()) {
                        orderItems!!.add(arrData!!.getJSONObject(i).getJSONArray("Items").getString(j))
                        println(orderItems)
                    }

                    var price = arrData!!.getJSONObject(i).getDouble("Price")
                    var date = arrData!!.getJSONObject(i).getString("date")
                    var userOrder = Order(data!!.names()!![i] as String, orderItems!!, price, date)
                    listItems!!.add(userOrder)
                    listAdapter!!.notifyDataSetChanged()
                }
            }
            loader!!.visibility = View.GONE
        }
    }
}
