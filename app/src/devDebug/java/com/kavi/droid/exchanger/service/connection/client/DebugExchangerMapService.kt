package com.kavi.droid.exchanger.service.connection.client

import com.kavi.droid.exchanger.service.connection.dto.response.BaseResponse
import com.kavi.droid.exchanger.service.connection.dto.response.ResBase
import com.kavi.droid.exchanger.service.connection.dto.response.data.ConsumerConfig
import com.kavi.droid.exchanger.service.connection.dto.response.data.SystemStatus
import com.kavi.droid.exchanger.service.connection.dto.response.data.TokenStatus
import com.kavi.droid.exchanger.service.connection.mock.AuthMockHelper
import com.kavi.droid.exchanger.service.connection.mock.CommonMockHelper
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
                "NodeGrid mBaaS status",
                CommonMockHelper.getSystemStatus())

        return delegate.returning(Calls.response(response)).getSystemStatus()
    }

    override fun getCurrentTokenStatus(): Observable<BaseResponse<List<ResBase<TokenStatus>>>> {
        val response: BaseResponse<List<ResBase<TokenStatus>>>? = BaseResponse("SUCCESS",
                "NodeGrid mBaaS status",
                AuthMockHelper.getCurrentTokenStatus())

        return delegate.returning(Calls.response(response)).getCurrentTokenStatus()
    }

    override fun getConsumerConfigurations(): Observable<BaseResponse<ConsumerConfig>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}