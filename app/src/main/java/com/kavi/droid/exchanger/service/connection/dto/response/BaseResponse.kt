package com.kavi.droid.exchanger.service.connection.dto.response

data class BaseResponse<T>(
        val status: String,
        val msg: String,
        val res: T
)