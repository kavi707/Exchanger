package com.kavi.droid.exchanger.ui.auth

import android.os.Bundle
import com.kavi.droid.exchanger.AppConstant
import com.kavi.droid.exchanger.R
import com.kavi.droid.exchanger.ui.ExchangerBaseActivity

class AuthActivity : ExchangerBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        setUpViews()
    }

    private fun setUpViews() {
        replaceFragmentView(AuthHomeFragment(), R.id.auth_frame_container, AppConstant.AUTH_HOME_FRAGMENT_TAG, null)
    }
}
