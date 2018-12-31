package com.kavi.droid.exchanger.service.connection.dto.response

data class ResBase<T> (
        val _id: String,
        val __v: Int,
        val data: T
)