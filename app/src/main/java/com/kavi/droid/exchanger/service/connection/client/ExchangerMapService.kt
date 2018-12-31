package com.kavi.droid.exchanger.service.connection.client

import com.kavi.droid.exchanger.service.connection.dto.response.*
import com.kavi.droid.exchanger.service.connection.dto.response.data.ConsumerConfig
import com.kavi.droid.exchanger.service.connection.dto.response.data.SystemStatus
import com.kavi.droid.exchanger.service.connection.dto.response.data.TokenStatus
import io.reactivex.Observable
import retrofit2.http.GET

interface ExchangerMapService {

    @GET("/auth/status")
    fun getSystemStatus(): Observable<BaseResponse<SystemStatus>>

    @GET("/auth/security/tokenStatus")
    fun getCurrentTokenStatus(): Observable<BaseResponse<List<ResBase<TokenStatus>>>>

    @GET("/auth/app/consumer/config")
    fun getConsumerConfigurations(): Observable<BaseResponse<ConsumerConfig>>
}