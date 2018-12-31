package com.kavi.droid.exchanger.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log

open class ExchangerBaseActivity: AppCompatActivity() {

    private val TAG = ExchangerBaseActivity::class.java.name

    /**
     * Replace given fragment in container from Activity
     * @param newFragment Fragment: New fragment view object
     * @param container Integer: Resource id of the view container
     * @param newFragmentTag String: New fragment tag name
     * @param data Bundle: Argument need to pass amount fragment
     */
    fun replaceFragmentView(newFragment: Fragment, container: Int, newFragmentTag: String, data: Bundle?) {
        if (newFragment != null) {
            if (data != null)
                newFragment.arguments = data
            val fragmentManager = supportFragmentManager
            fragmentManager.beginTransaction()
                    .replace(container, newFragment, newFragmentTag)
                    .commit()
        } else {
            // error in creating fragment
            Log.e(TAG, "ExchangerBaseActivity:replaceFragmentView / On Fragment form error: Fail to create Fragment")
        }
    }

    fun goBack() {
        this.supportFragmentManager.popBackStackImmediate()
    }
}