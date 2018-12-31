package com.kavi.droid.exchanger.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson
import java.util.*

open class ExchangerBaseFragment: Fragment() {

    private val TAG = ExchangerBaseFragment::class.java.name;

    private val gson: Gson? = Gson()
    var pageView: View? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    /**
     * Replace given fragment in container from Fragment
     * @param newFragment Fragment: New fragment view object
     * @param container Integer: Resource id of the view container
     * @param newFragmentTag String: New fragment tag name
     * @param isAddingBackStack Boolean: Flag for adding view to back stack or not
     * @param data Bundle: Argument need to pass amount fragment
     */
    fun replaceFragmentView(newFragment: Fragment,
                            container: Int,
                            newFragmentTag: String,
                            isAddingBackStack: Boolean,
                            data: Bundle) {

        if (newFragment != null) {
            if (data != null)
                newFragment.arguments = data
            val fragmentManager = Objects.requireNonNull<FragmentActivity>(activity).getSupportFragmentManager()
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(container, newFragment, newFragmentTag)
                    .commit()
            if (isAddingBackStack)
                fragmentTransaction.addToBackStack(null)
        } else {
            // error in creating fragment
            Log.e(TAG, "ExchangerBaseFragment:replaceFragmentView / On Fragment form error: Fail to create Fragment")
        }
    }

    fun goBack() {
        activity!!.supportFragmentManager.popBackStackImmediate()
    }

    fun setDataToBundle(key: String, data: Any): Bundle {
        val dataBundle = Bundle()
        dataBundle.putString(key, gson!!.toJson(data))
        return dataBundle;
    }

    fun getDataFromBundle(dataString: String, dataClass: Class<*>): Any {
        return gson!!.fromJson(dataString, dataClass)
    }
}