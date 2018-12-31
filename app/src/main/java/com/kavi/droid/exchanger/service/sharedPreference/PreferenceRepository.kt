package com.kavi.droid.exchanger.service.sharedPreference

import android.content.Context

class PreferenceRepository {

    companion object {
        private val IS_USER_LOGGED_IN = "IS_USER_LOGGED_IN"

        fun setIsLogIn(context: Context, value: Boolean) {
            SharedPreferenceManager.Companion.writeBooleanSharePreference(context, IS_USER_LOGGED_IN, value)
        }

        fun isUserLogIn(context: Context): Boolean {
            return SharedPreferenceManager.readBooleanSharePreference(context, IS_USER_LOGGED_IN)
        }
    }
}