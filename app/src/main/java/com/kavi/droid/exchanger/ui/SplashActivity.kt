package com.kavi.droid.exchanger.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.kavi.droid.exchanger.R
import com.kavi.droid.exchanger.service.connection.client.NetworkModule
import com.kavi.droid.exchanger.service.sharedPreference.PreferenceRepository
import com.kavi.droid.exchanger.ui.auth.AuthActivity
import com.kavi.droid.exchanger.ui.home.LandingActivity
import com.kavi.droid.exchanger.util.CommonUtil

class SplashActivity : ExchangerBaseActivity() {

    private val context: Context = this
    private val SPLASH_TIME_OUT: Long = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        setUpViews()
    }

    private fun setUpViews() {

        if (PreferenceRepository.isUserLogIn(context)) {
            if (CommonUtil.isOnline(context)) {
                NetworkModule.getAuthInterceptor().getCurrentTokenStatus()
                        .subscribe({
                            result ->
                            startActivity(Intent(this, LandingActivity::class.java))
                        }, {
                            error ->
                            goAuthFlow();
                        })
            }
        } else {
            /*NetworkModule.getCommonInterceptor().getSystemStatus()
                    .subscribe({
                        result ->
                        Log.d("TAG: NodeGrid Status: ", result.nodegridStatus)
                        Log.d("TAG: Mongo Status: ", result.mongoStatus)
                    }, {
                        error ->
                        Log.d("TAG: Error: ", error.message)
                    })*/
            goAuthFlow();
        }
    }

    private fun goAuthFlow() {
        Handler().postDelayed(Runnable {
            startActivity(Intent(context, AuthActivity::class.java))
        }, SPLASH_TIME_OUT)
    }
}
