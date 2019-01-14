package com.kavi.droid.exchanger.ui.view

import android.support.v7.widget.RecyclerView
import android.view.View
import com.kavi.droid.exchanger.service.connection.dto.response.data.Ticket
import kotlinx.android.synthetic.main.view_ticket_item.view.*

class TicketItemView(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var ticketItem: Ticket? = null

    fun setTicketItem(ticketItem: Ticket) {
        this.ticketItem = ticketItem

        setupView()
    }

    private fun setupView() {
        if (ticketItem?.reqType == Ticket.BUYING)
            itemView.reqTypeTextView.text = "I need"
        else
            itemView.reqTypeTextView.text = "I have"

        itemView.reqQtyTextView.text = String.format("%d %s", ticketItem?.qty, "Tickets");
    }
}