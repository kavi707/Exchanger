package com.kavi.droid.exchanger.service.connection.mock

import com.kavi.droid.exchanger.service.connection.dto.response.ResBase
import com.kavi.droid.exchanger.service.connection.dto.response.data.TokenStatus

class AuthMockHelper {

    companion object {
        fun getCurrentTokenStatus(): MutableList<ResBase<TokenStatus>> {

            var resList: MutableList<ResBase<TokenStatus>> = ArrayList()

            val tokenStatus = TokenStatus("72031d6ca788095442784d4f54a16bd6861a39d1",
                    "5b940e99f93f4fb5286feaf8",
                    1545685041,
                    1545771441,
                    "valid")

            val response = ResBase<TokenStatus>("5b940e99f93f4fb5286feaf9", 0, tokenStatus)

            resList.add(response)

            return resList
        }
    }
}