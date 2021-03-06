package com.adriancimpean.foodorder.menu

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.adriancimpean.foodorder.R
import com.adriancimpean.foodorder.authentication.AuthenticationActivity
import com.adriancimpean.foodorder.connection.ConnectionHandler
import com.adriancimpean.foodorder.menu.categories.*
import com.adriancimpean.foodorder.order.cart.CartActivity
import com.adriancimpean.foodorder.order.OrdersActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private var bottomNav : BottomNavigationView? = null
    private var data : JSONObject? = null
    private var pager : ViewPager? = null
    private var tabLayout : TabLayout? = null
    private var adapter = CategoriesFragmentAdapter(supportFragmentManager)

    inner class getCategories : AsyncTask<Void,Void,String>(){
        override fun doInBackground(vararg p0: Void?): String {
            return ConnectionHandler.getRequest("https://food-order-bbcce.firebaseio.com/Categories.json")
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            data = JSONObject(result)
            println(data!!.names())

            for(i in 0 until data?.names()!!.length()){
                tabLayout!!.addTab(tabLayout?.newTab()!!.setText(data?.names()!![i].toString()))
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNav = findViewById(R.id.bottomNav)
        tabLayout = findViewById(R.id.tabLayout)

        pager = findViewById(R.id.pager)
        tabLayout!!.tabGravity = TabLayout.GRAVITY_FILL

        adapter.addFragment(BurgersFragment())
        adapter.addFragment(DesertsFragment())
        adapter.addFragment(DrinksFragment())
        adapter.addFragment(PizzasFragment())

        pager!!.adapter=adapter
        pager!!.addOnPageChangeListener(object : TabLayout.TabLayoutOnPageChangeListener(tabLayout){})

        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {}

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabSelected(tab: TabLayout.Tab?) {
                pager!!.currentItem = tab!!.position
            }
        })

        bottomNav!!.selectedItemId = R.id.Menu

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

        if(ConnectionHandler.isNetworkAvailable(this)) {
            var getCategories = getCategories()
            getCategories.execute()
        } else {
            Snackbar.make(window.decorView.rootView, R.string.no_internet, Snackbar.LENGTH_SHORT).show()
        }
    }
}
