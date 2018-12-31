package com.kavi.droid.exchanger.service.connection.client

import com.kavi.droid.exchanger.service.connection.interceptor.AuthInterceptor
import com.kavi.droid.exchanger.service.connection.interceptor.CommonInterceptor

class NetworkModule {

    companion object {
        fun getCommonInterceptor(): CommonInterceptor {
            return CommonInterceptor()
        }

        fun getAuthInterceptor(): AuthInterceptor {
            return AuthInterceptor()
        }
    }
}