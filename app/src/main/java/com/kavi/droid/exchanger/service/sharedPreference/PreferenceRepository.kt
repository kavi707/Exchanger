package com.kavi.droid.exchanger.service.sharedPreference

import android.content.Context

class PreferenceRepository {

    companion object {
        private const val IS_USER_LOGGED_IN = "IS_USER_LOGGED_IN"
        private const val SELECTED_LOCAL = "SELECTED_LOCAL"

        fun setIsLogIn(context: Context, value: Boolean) {
            SharedPreferenceManager.Companion.writeBooleanSharePreference(context, IS_USER_LOGGED_IN, value)
        }

        fun isUserLogIn(context: Context): Boolean {
            return SharedPreferenceManager.readBooleanSharePreference(context, IS_USER_LOGGED_IN)
        }

        fun setSelectedLocal(context: Context, value: String) {
            SharedPreferenceManager.Companion.writeStringSharePreference(context, SELECTED_LOCAL, value)
        }

        fun getSelectedLocal(context: Context): String? {
            return SharedPreferenceManager.readStringSharePreference(context, SELECTED_LOCAL)
        }
    }
}