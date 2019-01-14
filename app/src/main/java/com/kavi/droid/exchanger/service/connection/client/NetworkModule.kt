package com.kavi.droid.exchanger.service.connection.client

import com.kavi.droid.exchanger.service.connection.interceptor.AuthInterceptor
import com.kavi.droid.exchanger.service.connection.interceptor.CommonInterceptor
import com.kavi.droid.exchanger.service.connection.interceptor.HomeInterceptor

class NetworkModule {

    companion object {
        fun getCommonInterceptor(): CommonInterceptor {
            return CommonInterceptor()
        }

        fun getAuthInterceptor(): AuthInterceptor {
            return AuthInterceptor()
        }

        fun getHomeInterceptor(): HomeInterceptor {
            return HomeInterceptor()
        }
    }
}