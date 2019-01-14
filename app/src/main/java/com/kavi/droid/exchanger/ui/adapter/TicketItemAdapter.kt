package com.kavi.droid.exchanger.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.kavi.droid.exchanger.R
import com.kavi.droid.exchanger.service.connection.dto.response.data.Ticket
import com.kavi.droid.exchanger.ui.view.TicketItemView

class TicketItemAdapter() : RecyclerView.Adapter<TicketItemView>() {

    private lateinit var layoutInflater: LayoutInflater
    private var context: Context? = null
    private lateinit var ticketList: List<Ticket>

    constructor(context: Context?, ticketList: List<Ticket>) : this() {
        this.context = context
        this.ticketList = ticketList
        this.layoutInflater = LayoutInflater.from(context)
    }

    override fun getItemCount(): Int {
        return ticketList.size
    }

    override fun onBindViewHolder(holder: TicketItemView, position: Int) {
        holder.setTicketItem(ticketList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketItemView {
        val view = layoutInflater.inflate(R.layout.view_ticket_item, parent, false)
        return TicketItemView(view)
    }
}