package com.kavi.droid.exchanger.ui.home

import android.content.AbstractThreadedSyncAdapter
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kavi.droid.exchanger.R
import com.kavi.droid.exchanger.service.connection.client.NetworkModule
import com.kavi.droid.exchanger.service.connection.dto.response.data.Ticket
import com.kavi.droid.exchanger.ui.ExchangerBaseFragment
import com.kavi.droid.exchanger.ui.adapter.TicketItemAdapter
import kotlinx.android.synthetic.main.fragment_landing_home.view.*

class HomeFragment: ExchangerBaseFragment() {

    private lateinit var ticketItemAdapter: TicketItemAdapter
    private lateinit var currentPageView: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_landing_home, container, false)
        pageView = view
        currentPageView = view

        return view
    }

    override fun onResume() {
        super.onResume()
        fetchTicketList()
    }

    private fun fetchTicketList() {
        NetworkModule.getHomeInterceptor().getTicketRequests()
                .subscribe({
                    result ->
                    val list = result.toList()
                    val ticketList: MutableList<Ticket> = ArrayList()
                    for(item in list) {
                        ticketList.add(item.data)
                    }
                    ticketItemAdapter = TicketItemAdapter(context, ticketList)
                    currentPageView.ticketRequestRecycleView.layoutManager = LinearLayoutManager(activity)
                    currentPageView.ticketRequestRecycleView.adapter = ticketItemAdapter
                }, {
                    error ->
                })
    }

    private fun updateTicketList(ticketList: List<Ticket>) {

    }
}