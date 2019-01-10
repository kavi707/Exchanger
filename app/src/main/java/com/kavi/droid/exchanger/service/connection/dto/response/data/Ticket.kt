package com.kavi.droid.exchanger.service.connection.dto.response.data

import android.support.annotation.IntDef

data class Ticket(
        val id: String,
        val name: String,
        val phoneNo: String,
        val email: String,
        @Type
        val reqType: Int,
        val trip: Int,
        val qty: Int,
        val description: String,
        val date: Long,
        val ticketDate: String,
        val ticketTime: String,
        val ticketDay: String,
        val userPicUrl: String,
        @Status
        val ticketStatus: Int
) {

    companion object {
        // Type
        const val SELLING = 0
        const val BUYING = 1

        // Status
        const val AVAILABLE = 0
        const val EXCHANGED = 1
        const val DRAFTED = 2
    }

    @IntDef(SELLING, BUYING)
    @Retention(AnnotationRetention.SOURCE)
    annotation class Type

    @IntDef(AVAILABLE, EXCHANGED, DRAFTED)
    @Retention(AnnotationRetention.SOURCE)
    annotation class Status
}