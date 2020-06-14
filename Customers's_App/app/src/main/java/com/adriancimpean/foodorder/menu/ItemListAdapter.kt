package com.adriancimpean.foodorder.menu

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.adriancimpean.foodorder.R
import com.adriancimpean.foodorder.order.Item
import com.adriancimpean.foodorder.order.cart.Cart

class ItemListAdapter : ArrayAdapter<Item> {
    private var mContext : Context
    private var mResource : Int? = null

    constructor(context: Context, resource : Int, items : ArrayList<Item>) : super(context, resource, items){
        mContext=context
        mResource = resource
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemName = getItem(position)?.Name
        var itemDescription = getItem(position)?.Description
        var itemPrice = getItem(position)?.Price


        val retView : View = LayoutInflater.from(mContext).inflate(R.layout.custom_menu_list,parent,false)


        var nameText = retView.findViewById(R.id.itemNameText) as? TextView
        var description = retView.findViewById(R.id.itemDescriptionText) as? TextView
        var price = retView.findViewById(R.id.itemPriceText) as? TextView
        var addButton = retView.findViewById(R.id.removeButton) as? Button

        nameText?.text=itemName
        description?.text = itemDescription
        price?.text = itemPrice.toString()+"ron"

        addButton!!.setOnClickListener {
            var item = Item(itemName,itemDescription,itemPrice)
            Cart.addToCart(item)
            Toast.makeText(context,"$itemName successfully added to cart", Toast.LENGTH_SHORT).show()
        }

        return retView
    }
}