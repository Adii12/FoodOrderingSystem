package com.adriancimpean.foodorder.menu.categories

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.adriancimpean.foodorder.menu.categories.BurgersFragment
import com.adriancimpean.foodorder.menu.categories.DesertsFragment
import com.adriancimpean.foodorder.menu.categories.DrinksFragment
import com.adriancimpean.foodorder.menu.categories.PizzasFragment

class CategoriesFragmentAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager)  {
    private var fragmentList : ArrayList<Fragment> = ArrayList()

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getCount(): Int {
       return fragmentList.size
    }

    fun addFragment(fragment: Fragment){
        fragmentList.add(fragment)
    }
}