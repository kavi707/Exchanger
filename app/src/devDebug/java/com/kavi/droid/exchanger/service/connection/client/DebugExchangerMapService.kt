package com.kavi.droid.exchanger.service.connection.client

import com.kavi.droid.exchanger.service.connection.dto.response.BaseResponse
import com.kavi.droid.exchanger.service.connection.dto.response.ResBase
import com.kavi.droid.exchanger.service.connection.dto.response.data.ConsumerConfig
import com.kavi.droid.exchanger.service.connection.dto.response.data.SystemStatus
import com.kavi.droid.exchanger.service.connection.dto.response.data.TokenStatus
import io.reactivex.Observable
import retrofit2.mock.BehaviorDelegate
import retrofit2.mock.Calls
import retrofit2.mock.MockRetrofit

class DebugExchangerMapService(mockRetrofit: MockRetrofit) : ExchangerMapService {

    var delegate: BehaviorDelegate<ExchangerMapService>

    init {
        delegate = mockRetrofit.create(ExchangerMapService::class.java)
    }

    override fun getSystemStatus(): Observable<BaseResponse<SystemStatus>> {
        val response: BaseResponse<SystemStatus>? = BaseResponse("SUCCESS",
                "Successfully get data",
                SystemStatus("GOOD", "CONNECTED"))

        return delegate.returning(Calls.response(response)).getSystemStatus()
    }

    override fun getCurrentTokenStatus(): Observable<BaseResponse<List<ResBase<TokenStatus>>>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getConsumerConfigurations(): Observable<BaseResponse<ConsumerConfig>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}