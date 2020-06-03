package com.adriancimpean.foodorder.order.cart

import android.content.Context
import android.widget.Toast
import com.adriancimpean.foodorder.menu.MainActivity
import com.adriancimpean.foodorder.order.Item

object Cart {
    private var cartItems : ArrayList<Item>? = ArrayList()
    private var totalPrice : Double = 0.0

    fun addToCart(item : Item){
        cartItems?.add(item)
    }

    fun getCart() : ArrayList<Item>? {
        return cartItems
    }

    fun getTotalPrice() : Double{
        totalPrice=0.0
        for(i in 0 until cartItems!!.size){
            totalPrice += cartItems!![i].Price!!
        }

        return totalPrice
    }

    fun removeFromCart(item : Item){
        cartItems!!.remove(item)
        println("Cart - removed")
        totalPrice-=item.Price!!
    }

    fun resetCart(){
        cartItems!!.clear()
    }
}