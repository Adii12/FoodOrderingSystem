package com.adriancimpean.foodorder.authentication

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class AuthenticationFragmentAdapter(fragmentManager : FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

     private var fragmentList : ArrayList<Fragment> = ArrayList()

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

    fun addFragment(fragment : Fragment){
        fragmentList.add(fragment)
    }
}