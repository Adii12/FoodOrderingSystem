package com.adriancimpean.foodorder.menu

import android.content.Intent
import android.opengl.Visibility
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.ProgressBar
import com.adriancimpean.foodorder.R
import com.adriancimpean.foodorder.authentication.AuthenticationActivity
import com.adriancimpean.foodorder.connection.FetchData
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private var listView : ListView? = null
    private var listItems : ArrayList<String>? = null
    private var listAdapter : ArrayAdapter<String>? = null
    private var bottomNav : BottomNavigationView? = null
    private var data : JSONObject? = null
    private var loader : ProgressBar? = null

    inner class getCategories : AsyncTask<Void,Void,String>(){
        override fun onPreExecute() {
            super.onPreExecute()
            loader!!.visibility=View.VISIBLE
        }

        override fun doInBackground(vararg p0: Void?): String {
            return FetchData.getRequest("https://food-order-bbcce.firebaseio.com/Categories.json")
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            data = JSONObject(result)
            println(data!!.names())

            for(i in 0 until data?.names()!!.length()){
               listItems!!.add(data?.names()!![i].toString())
            }
            loader!!.visibility=View.GONE
            listAdapter!!.notifyDataSetChanged()

        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var getCategories = getCategories()

        listView=findViewById(R.id.categoriesMenu)
        loader=findViewById(R.id.loader)
        loader!!.visibility= View.GONE

        bottomNav=findViewById(R.id.bottomNav)
        bottomNav!!.selectedItemId = R.id.Menu

        listItems = ArrayList()

        listAdapter = ArrayAdapter(this,R.layout.custom_row,R.id.Name, listItems!!)

        listView!!.adapter=listAdapter

        bottomNav!!.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.Orders -> {
                    startActivity(Intent(this, OrdersActivity::class.java))
                    overridePendingTransition(0,0)
                }

                R.id.Cart -> {
                    startActivity(Intent(this, CartActivity::class.java))
                    overridePendingTransition(0,0)
                }

                R.id.LogOut -> {
                    startActivity(Intent(this, AuthenticationActivity::class.java))
                    overridePendingTransition(0,0)
                }

            }
            true

        }


        getCategories.execute()

    }
}
