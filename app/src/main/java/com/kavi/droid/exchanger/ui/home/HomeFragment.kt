package com.kavi.droid.exchanger.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kavi.droid.exchanger.R
import com.kavi.droid.exchanger.service.connection.dto.response.data.Ticket
import com.kavi.droid.exchanger.ui.ExchangerBaseFragment

class HomeFragment: ExchangerBaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_landing_home, container, false)
        pageView = view

        setUpView(view)
        return view
    }

    override fun onResume() {
        super.onResume()
        fetchTicketList()
    }

    private fun setUpView(view: View?) {

    }

    private fun fetchTicketList() {

    }

    private fun updateTicketList(ticketList: List<Ticket>) {

    }
}