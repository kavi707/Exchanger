package com.kavi.droid.exchanger.util

import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import android.location.LocationManager
import android.net.ConnectivityManager
import android.net.NetworkInfo
import com.kavi.droid.exchanger.service.sharedPreference.PreferenceRepository
import java.util.*

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

        fun setLocale(activity: Activity) {
            var lanToLoad: String
            val selectedLocal = PreferenceRepository.getSelectedLocal(activity)
            if (!"NULL".equals(selectedLocal)) {
                lanToLoad = selectedLocal.toString()
            } else {
                PreferenceRepository.setSelectedLocal(activity, "en")
                lanToLoad = "en"
            }

            val locale = Locale(lanToLoad)
            Locale.setDefault(locale)
            val config = Configuration()
            config.locale = locale
            activity.baseContext.resources.updateConfiguration(config, activity.baseContext.resources.displayMetrics)
        }
    }
}