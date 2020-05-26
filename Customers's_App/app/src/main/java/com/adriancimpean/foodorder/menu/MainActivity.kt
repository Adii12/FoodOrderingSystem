package com.adriancimpean.foodorder.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView
import com.adriancimpean.foodorder.R
import com.adriancimpean.foodorder.authentication.AuthenticationActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private var listView : ListView? = null
    private var listItems : ArrayList<String>? = null
    private var listAdapter : ArrayAdapter<String>? = null
    private var bottomNav : BottomNavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView=findViewById(R.id.categoriesMenu)

        bottomNav=findViewById(R.id.bottomNav)
        bottomNav!!.selectedItemId = R.id.Menu

        listItems = ArrayList()
        listItems!!.add("Pizza")
        listItems!!.add("Burgers")
        listItems!!.add("Drinks")

        listAdapter = ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item, listItems!!)

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
    }
}
