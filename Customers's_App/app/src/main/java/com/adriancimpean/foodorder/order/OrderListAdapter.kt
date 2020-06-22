package com.adriancimpean.foodorder.order

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.adriancimpean.foodorder.R

class OrderListAdapter(context: Context, resource: Int, orders: ArrayList<Order>) :
    ArrayAdapter<Order>(context, resource, orders) {
    private var mContext : Context = context
    private var mResource : Int = resource

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var orderID = getItem(position)?.id
        var orderDate = getItem(position)?.date
        var ordersList = getItem(position)?.items
        var totalPrice = getItem(position)?.totalPrice

        val retView = LayoutInflater.from(mContext).inflate(R.layout.custom_order_list, parent, false)

        var orderIdText = retView.findViewById(R.id.orderIdText) as TextView
        var orderInfo = retView.findViewById(R.id.orderInfo) as ImageButton

        orderIdText.text=orderDate

        orderInfo.setOnClickListener {
            var orderDetailsActivity = Intent(context, OrderDetailsActivity::class.java)
            orderDetailsActivity.putExtra("order-id", orderID)
            mContext.startActivity(orderDetailsActivity)
        }

        return retView
    }
}