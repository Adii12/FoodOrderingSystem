package com.adriancimpean.foodorder.authentication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.adriancimpean.foodorder.R

class AuthenticationActivity : AppCompatActivity() {

    private var pager: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)

        pager = findViewById(R.id.pager)

        val pageAdapter = AuthenticationFragmentAdapter(supportFragmentManager)

        pageAdapter.addFragment(LoginFragment())
        pageAdapter.addFragment(RegisterFragment())
        pager!!.adapter=pageAdapter
    }
}
