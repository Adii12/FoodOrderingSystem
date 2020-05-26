package com.adriancimpean.foodorder.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adriancimpean.foodorder.R
import com.adriancimpean.foodorder.authentication.AuthenticationActivity
import com.google.android.material.bottomnavigation.BottomNavigationView


class OrdersActivity : AppCompatActivity() {
    private var bottomNav : BottomNavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orders)
        bottomNav=findViewById(R.id.bottomNav)
        bottomNav!!.selectedItemId = R.id.Orders

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
}
