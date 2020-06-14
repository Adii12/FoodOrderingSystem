package com.adriancimpean.foodorder.order

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.adriancimpean.foodorder.R

class OrderListAdapter : ArrayAdapter<Order> {
    private var mContext : Context
    private var mResource : Int? = null

    constructor(context: Context, resource : Int, orders : ArrayList<Order>) : super(context, resource, orders){
        mContext=context
        mResource = resource
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var orderID = getItem(position)?.id
        var ordersList = getItem(position)?.items
        var totalPrice = getItem(position)?.totalPrice

        val retView = LayoutInflater.from(mContext).inflate(R.layout.custom_order_list, parent, false)

        var orderIdText = retView.findViewById(R.id.orderIdText) as TextView
        var orderInfo = retView.findViewById(R.id.orderInfo) as ImageButton

        orderIdText.text=orderID

        return retView
    }
}