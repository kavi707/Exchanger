package com.kavi.droid.exchanger.util

import android.content.Context
import android.location.LocationManager
import android.net.ConnectivityManager
import android.net.NetworkInfo

class CommonUtil {

    companion object {
        fun isOnline(context: Context): Boolean {
            val connectivityManager: ConnectivityManager? = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
            val activeNetwork: NetworkInfo? = connectivityManager!!.activeNetworkInfo
            return activeNetwork!!.isConnected
        }

        fun isLocationServiceAvailable(context: Context): Boolean {
            val manager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
            return manager.isProviderEnabled(LocationManager.GPS_PROVIDER)
        }
    }
}