package com.kavi.droid.exchanger.service.connection.dto.response.data

import com.kavi.droid.exchanger.model.Destination
import java.util.*

data class ConsumerConfig(
        val supportCurrency: Currency,
        val destinations: List<Destination>
)