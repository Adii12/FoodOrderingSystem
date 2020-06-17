package com.adriancimpean.foodorder.location

import android.content.Context
import android.location.Address
import android.location.Geocoder
import java.util.*

class AddressHandler(context: Context) {
    var mContext = context
    var geocoder : Geocoder? = null
    var addresses : List<Address>? = null

    fun getAdresses(latitude : Double?, longitude : Double?) : Address?{
        geocoder = Geocoder(mContext, Locale.getDefault())
        addresses = geocoder?.getFromLocation(latitude!!, longitude!!, 1)
        var addr = addresses?.get(0)

        return addr
    }


}