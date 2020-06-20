package com.adriancimpean.foodorder.location

import android.content.Context
import android.location.Address
import android.location.Geocoder
import java.util.*

class AddressHandler(context: Context, latitude: Double?, longitude: Double?)   {
    var mContext = context
    var geocoder : Geocoder
    var addresses : List<Address>
    var lat = latitude
    var lon = longitude
    var address : Address

    init {
        geocoder = Geocoder(mContext, Locale.getDefault())
        addresses = geocoder.getFromLocation(latitude!!, longitude!!, 1)
        address = addresses[0]
    }

   /* fun getAdresses(latitude : Double?, longitude : Double?) : Address?{
        geocoder = Geocoder(mContext, Locale.getDefault())
        addresses = geocoder?.getFromLocation(latitude!!, longitude!!, 1)
        var addr = addresses?.get(0)

        return addr
    }*/

    fun getCity() : String {
        return address.locality
    }

    fun getCounty() : String{
        return address.adminArea
    }

    fun getStreetName() : String? {
        val splitAddress = address.getAddressLine(0)?.split(",")

        return splitAddress?.get(0)
    }

    fun getStreetNumber() : String? {
        val splitAddress = address.getAddressLine(0)?.split(",")

        return splitAddress?.get(1)
    }



}