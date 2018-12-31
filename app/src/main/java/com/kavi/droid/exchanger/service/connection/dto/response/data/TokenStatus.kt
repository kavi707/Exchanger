package com.kavi.droid.exchanger.service.connection.dto.response.data

data class TokenStatus (
        val accessToken: String,
        val userId: String,
        val createdTime: Long,
        val expiringTime: Long,
        val status: String
)