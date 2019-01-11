package com.kavi.droid.exchanger.service.connection.mock

import com.kavi.droid.exchanger.service.connection.dto.response.BaseResponse
import com.kavi.droid.exchanger.service.connection.dto.response.data.SystemStatus

class CommonMockHelper {

    companion object {
        fun getSystemStatus(): SystemStatus {
            return SystemStatus("GOOD", "CONNECTED")
        }
    }
}