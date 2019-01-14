package com.kavi.droid.exchanger.service.connection.interceptor

import com.kavi.droid.exchanger.service.connection.client.HttpClient
import com.kavi.droid.exchanger.service.connection.dto.response.ResBase
import com.kavi.droid.exchanger.service.connection.dto.response.data.Ticket
import com.kavi.droid.exchanger.service.connection.dto.response.data.TokenStatus
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HomeInterceptor {

    fun getTicketRequests(): Observable<List<ResBase<Ticket>>> {
        return HttpClient.create().getTicketRequests()
                .subscribeOn(Schedulers.io())
                .map { exchangerResponse -> exchangerResponse.res }
                .observeOn(AndroidSchedulers.mainThread())
    }
}