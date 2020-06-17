package com.adriancimpean.foodorder.order

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import com.adriancimpean.foodorder.R
import com.adriancimpean.foodorder.connection.ConnectionHandler
import org.json.JSONObject

class OrderDetailsActivity : AppCompatActivity() {
    private var data : JSONObject? = null
    private var itemList : ArrayList<String>? = null
    private var adapter : ArrayAdapter<String>? = null
    private var list : ListView? = null
    private var backButton : Button? = null
    private var tvTotalPrice : TextView? = null
    private var tvStatus : TextView? = null
    private var tvCounty : TextView? = null
    private var tvCity : TextView? = null
    private var tvStreetName : TextView? = null
    private var tvStreetNumber : TextView? = null
    private var tvFirstName : TextView? = null
    private var tvLastName : TextView? = null
    private var tvPhoneNumber : TextView? = null

    inner class getOrderDetails : AsyncTask<String, Void, String>(){
        override fun doInBackground(vararg orderURL: String?): String {
            return ConnectionHandler.getRequest("https://food-order-bbcce.firebaseio.com/Orders/"+orderURL[0]+".json")
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            data = JSONObject(result!!)
            var dataArr = data?.getJSONArray("Items")

            for(i in 0 until dataArr!!.length()){
                itemList!!.add(dataArr.get(i).toString())
                println(dataArr.get(i).toString())
                adapter?.notifyDataSetChanged()
            }


            tvTotalPrice?.text = data?.getDouble("Price").toString()
            tvStatus?.text = data?.getString("status")
            tvCounty?.text = data?.getString("county")
            tvCity?.text = data?.getString("city")
            tvStreetName?.text = data?.getString("street name")
            tvStreetNumber?.text = data?.getString("street no")
            tvFirstName?.text = data?.getString("first name")
            tvLastName?.text = data?.getString("last name")
            tvPhoneNumber?.text = data?.getString("phone number")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_details)

        list=findViewById(R.id.itemList)
        backButton=findViewById(R.id.backBtn)
        tvTotalPrice=findViewById(R.id.tvTotalPrice)
        tvStatus=findViewById(R.id.tvStatus)
        tvCounty=findViewById(R.id.tvCounty)
        tvCity=findViewById(R.id.tvCity)
        tvStreetName=findViewById(R.id.tvStreetName)
        tvStreetNumber=findViewById(R.id.tvStreetNumber)
        tvFirstName=findViewById(R.id.tvFirstName)
        tvLastName=findViewById(R.id.tvLastName)
        tvPhoneNumber=findViewById(R.id.tvPhoneNo)

        itemList = ArrayList()
        adapter = ArrayAdapter(this@OrderDetailsActivity, R.layout.simple_list, R.id.tvItemName, itemList!!)
        list?.adapter=adapter

        var orderID = intent.getStringExtra("order-id")
        println(orderID)
        var getOrderDetails = getOrderDetails()
        getOrderDetails.execute(orderID)

        backButton?.setOnClickListener {
            finish()
        }
    }
}