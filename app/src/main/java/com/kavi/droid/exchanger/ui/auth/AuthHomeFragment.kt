package com.kavi.droid.exchanger.ui.auth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.kavi.droid.exchanger.R
import com.kavi.droid.exchanger.ui.ExchangerBaseFragment
import com.kavi.droid.exchanger.ui.home.LandingActivity
import kotlinx.android.synthetic.main.fragment_auth_home.view.*

class AuthHomeFragment: ExchangerBaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_auth_home, container, false)
        pageView = view

        setUpView(view)
        return view
    }

    private fun setUpView(pageView: View) {

        pageView.login_with_facebook_view.setOnClickListener { view ->
            startActivity(Intent(activity, LandingActivity::class.java))
            Toast.makeText(context, "", Toast.LENGTH_LONG).show()
        }

        pageView.login_with_google_view.setOnClickListener { view ->
            //startActivity(Intent(activity, LandingActivity::class.java))
        }
    }
}