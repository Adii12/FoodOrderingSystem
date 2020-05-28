package com.adriancimpean.foodorder.menu

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.adriancimpean.foodorder.menu.categories.BurgersFragment
import com.adriancimpean.foodorder.menu.categories.DesertsFragment
import com.adriancimpean.foodorder.menu.categories.DrinksFragment
import com.adriancimpean.foodorder.menu.categories.PizzasFragment

class CategoriesFragmentAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager)  {
    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> BurgersFragment()
            1 -> PizzasFragment()
            2 -> DesertsFragment()
            3 -> DrinksFragment()
            else -> BurgersFragment()
        }
    }

    override fun getCount(): Int {
        return 4
    }
}