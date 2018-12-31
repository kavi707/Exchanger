package com.kavi.droid.exchanger.service.connection.interceptor

import com.kavi.droid.exchanger.service.connection.client.HttpClient
import com.kavi.droid.exchanger.service.connection.dto.response.ResBase
import com.kavi.droid.exchanger.service.connection.dto.response.data.TokenStatus
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AuthInterceptor {

    fun getCurrentTokenStatus(): Observable<List<ResBase<TokenStatus>>> {
        return HttpClient.create().getCurrentTokenStatus()
                .subscribeOn(Schedulers.io())
                .map { exchangerResponse -> exchangerResponse.res }
                .observeOn(AndroidSchedulers.mainThread())
    }
}