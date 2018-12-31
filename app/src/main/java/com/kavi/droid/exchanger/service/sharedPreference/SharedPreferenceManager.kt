package com.kavi.droid.exchanger.service.sharedPreference

import android.content.Context
import com.google.gson.Gson

class SharedPreferenceManager {

    companion object {

        private val EXCHANGER_SHARED_PREFERENCE = "EXCHANGER_SHARED_PREFERENCE"

        /**
         * Store boolean shared preference value
         * @param preferenceKey preference key
         * @param preferenceValue preference value
         */
        fun writeBooleanSharePreference(context: Context, preferenceKey: String, preferenceValue: Boolean) {

            // We need an Editor object to make preference changes.
            // All objects are from android.context.Context
            val settings = context.getSharedPreferences(EXCHANGER_SHARED_PREFERENCE, 0)
            val editor = settings.edit()
            editor.putBoolean(preferenceKey, preferenceValue)

            // Commit the edits!
            editor.apply()
        }

        /**
         * Get boolean share preference value
         * @param preferenceKey preference key
         * @return boolean value
         */
        fun readBooleanSharePreference(context: Context, preferenceKey: String): Boolean {
            val settings = context.getSharedPreferences(EXCHANGER_SHARED_PREFERENCE, 0)
            return settings.getBoolean(preferenceKey, false)
        }

        /**
         * Store String shared preference value
         * @param preferenceKey preference key
         * @param preferenceValue preference value
         */
        fun writeStringSharePreference(context: Context, preferenceKey: String, preferenceValue: String) {

            // We need an Editor object to make preference changes.
            // All objects are from android.context.Context
            val settings = context.getSharedPreferences(EXCHANGER_SHARED_PREFERENCE, 0)
            val editor = settings.edit()
            editor.putString(preferenceKey, preferenceValue)

            // Commit the edits!
            editor.apply()
        }

        /**
         * Get String share preference value
         * @param preferenceKey preference key
         * @return String value
         */
        fun readStringSharePreference(context: Context, preferenceKey: String): String? {
            val settings = context.getSharedPreferences(EXCHANGER_SHARED_PREFERENCE, 0)
            return settings.getString(preferenceKey, "NULL")
        }

        /**
         * Store String shared preference value
         * @param preferenceKey preference key
         * @param preferenceValue preference value
         */
        fun writeObjectSharePreference(context: Context, preferenceKey: String, preferenceValue: Any) {

            // We need an Editor object to make preference changes.
            // All objects are from android.context.Context
            val settings = context.getSharedPreferences(EXCHANGER_SHARED_PREFERENCE, 0)
            val editor = settings.edit()

            val gson = Gson()
            val jsonString = gson.toJson(preferenceValue)
            editor.putString(preferenceKey, jsonString)

            // Commit the edits!
            editor.apply()
        }

        /**
         * Get String share preference value
         * @param preferenceKey preference key
         * @return String value
         */
        fun readObjectSharePreference(context: Context, preferenceKey: String, objectClass: Class<*>): Any? {
            val settings = context.getSharedPreferences(EXCHANGER_SHARED_PREFERENCE, 0)

            val gson = Gson()
            val jsonString = settings.getString(preferenceKey, null)

            if (jsonString != null)
                return gson.fromJson(jsonString, objectClass)
            else
                return null
        }
    }
}