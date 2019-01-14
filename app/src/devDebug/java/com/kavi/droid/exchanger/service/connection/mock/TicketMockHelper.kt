package com.kavi.droid.exchanger.service.connection.mock

import com.kavi.droid.exchanger.service.connection.dto.response.ResBase
import com.kavi.droid.exchanger.service.connection.dto.response.data.Ticket
import com.kavi.droid.exchanger.service.connection.dto.response.data.TokenStatus

class TicketMockHelper {

    companion object {
        fun getTicketRequests(): MutableList<ResBase<Ticket>> {

            var resList: MutableList<ResBase<Ticket>> = ArrayList()

            val data01 = Ticket("72031d6ca788095442784d4f54a16bd6861a39d1",
                    "Kavimal One",
                    "4123209979",
                    "kavi@gmail.com",
                    Ticket.BUYING,
                    1,
                    1,
                    "I have one ticket from K2C on next monday",
                    1547328233,
                    "2019-01-31",
                    "5.30",
                    "Monday",
                    "",
                    Ticket.AVAILABLE)

            val data02 = Ticket("72031d6ca788095442784d4f54a16bd6861a39d1",
                    "Kavimal Two",
                    "4123209979",
                    "kavi@gmail.com",
                    Ticket.SELLING,
                    1,
                    2,
                    "I have one ticket from K2C on next monday",
                    1547328233,
                    "2019-01-31",
                    "5.30",
                    "Monday",
                    "",
                    Ticket.AVAILABLE)

            val data03 = Ticket("72031d6ca788095442784d4f54a16bd6861a39d1",
                    "Kavimal Three",
                    "4123209979",
                    "kavi@gmail.com",
                    Ticket.SELLING,
                    1,
                    3,
                    "I have one ticket from K2C on next monday",
                    1547328233,
                    "2019-01-31",
                    "5.30",
                    "Monday",
                    "",
                    Ticket.AVAILABLE)

            val ticket01 = ResBase<Ticket>("5b940e99f93f4fb5286feaf9", 0, data01)
            resList.add(ticket01)
            val ticket02 = ResBase<Ticket>("5b940e99f93f4fb5286feaf9", 0, data02)
            resList.add(ticket02)
            val ticket03 = ResBase<Ticket>("5b940e99f93f4fb5286feaf9", 0, data03)
            resList.add(ticket03)


            return resList
        }
    }
}