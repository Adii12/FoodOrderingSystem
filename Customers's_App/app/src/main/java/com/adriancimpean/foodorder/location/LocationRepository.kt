package com.adriancimpean.foodorder.location

import android.Manifest
import android.app.Activity
import android.app.Service
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.os.IBinder
import android.widget.Toast

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import java.lang.Exception

class LocationRepository(context: Context, activity: Activity) : LocationListener, Service() {
    private var mContext : Context = context
    private var mActivity : Activity = activity

    private var isGPSEnabled : Boolean? = null
    private var isNetworkEnabled : Boolean? = null


    private var latitude : Double? = null
    private var longitude : Double? = null


    private var location : Location? = null

    private var locationManager : LocationManager? = null

    fun getLocation() : Location{
        try {
            locationManager = mContext.getSystemService(Context.LOCATION_SERVICE) as LocationManager?
            isGPSEnabled = locationManager?.isProviderEnabled(LocationManager.GPS_PROVIDER)
            isNetworkEnabled = locationManager?.isProviderEnabled(LocationManager.NETWORK_PROVIDER)

            if(!isNetworkEnabled!! && !isGPSEnabled!!) {
                Toast.makeText(mContext, "Can't get location", Toast.LENGTH_SHORT).show()
            } else {
                //canGetLocation = true

                if(isNetworkEnabled!!) {
                    if(ContextCompat.checkSelfPermission(mActivity,Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                        ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)!=PackageManager.PERMISSION_GRANTED){
                        ActivityCompat.requestPermissions(mActivity, arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION), 50)
                    } else {
                        locationManager?.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0.0f, this)
                    }

                    location = locationManager?.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)

                    if(location!=null){
                        latitude = location!!.latitude
                        longitude = location!!.longitude
                    }
                }

                if(isGPSEnabled!!){
                    if(location==null){
                        if(ContextCompat.checkSelfPermission(mActivity,Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)!=PackageManager.PERMISSION_GRANTED){
                            ActivityCompat.requestPermissions(mActivity, arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION), 50)
                        } else {
                            locationManager?.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0.0f, this)
                        }

                        location = locationManager?.getLastKnownLocation(LocationManager.GPS_PROVIDER)

                        if(location != null) {
                            latitude = location!!.latitude
                            longitude = location!!.longitude
                        }
                    }
                }
            }
        }catch (ex : Exception){
            ex.printStackTrace()
        }

        return location!!
    }

    fun getLatitutde() : Double?{
        getLocation()
        if(location!=null){
            latitude = location?.latitude
        }

        return latitude
    }

    fun getLongitude() : Double?{
        getLocation()
        if(location!=null){
            longitude = location?.longitude
        }

        return longitude
    }

    override fun onLocationChanged(p0: Location?) {
    }

    override fun onStatusChanged(p0: String?, p1: Int, p2: Bundle?) {
    }

    override fun onProviderEnabled(p0: String?) {
    }

    override fun onProviderDisabled(p0: String?) {
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

}