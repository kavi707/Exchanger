package com.kavi.droid.exchanger.service.connection.interceptor

import com.kavi.droid.exchanger.service.connection.client.HttpClient
import com.kavi.droid.exchanger.service.connection.dto.response.data.SystemStatus
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class CommonInterceptor {

    fun getSystemStatus(): Observable<SystemStatus> {
        return HttpClient.create().getSystemStatus()
                .subscribeOn(Schedulers.io())
                .map { exchangerResponse -> exchangerResponse.res }
                .observeOn(AndroidSchedulers.mainThread())
    }
}