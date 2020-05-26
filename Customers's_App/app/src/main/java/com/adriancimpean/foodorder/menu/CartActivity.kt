package com.adriancimpean.foodorder.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adriancimpean.foodorder.R
import com.adriancimpean.foodorder.authentication.AuthenticationActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class CartActivity : AppCompatActivity() {

    private var bottomNav : BottomNavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

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
