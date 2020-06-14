package com.adriancimpean.foodorder.order.cart

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.adriancimpean.foodorder.R
import com.adriancimpean.foodorder.order.Item

class CartListAdapter : ArrayAdapter<Item> {
    private var mContext: Context
    private var mResource: Int? = null

    constructor(context: Context, resource: Int, items: ArrayList<Item>) : super(
        context,
        resource,
        items
    ) {
        mContext = context
        mResource = resource
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemName = getItem(position)?.Name
        var itemDescription = getItem(position)?.Description
        var itemPrice = getItem(position)?.Price

        val retView: View =
            LayoutInflater.from(mContext).inflate(R.layout.custom_cart_list, parent, false)

        var nameText = retView.findViewById(R.id.itemNameText) as? TextView
        var description = retView.findViewById(R.id.itemDescriptionText) as? TextView
        var price = retView.findViewById(R.id.itemPriceText) as? TextView
        var removeButton = retView.findViewById(R.id.removeButton) as? Button


        nameText?.text = itemName
        description?.text = itemDescription
        price?.text = itemPrice.toString() + "ron"


        removeButton?.setOnClickListener {
            var item = getItem(position)
            Cart.removeFromCart(item!!)
            println("Adapter - removed")
            notifyDataSetChanged()
        }
        return retView
    }
}