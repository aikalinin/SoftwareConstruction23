package org.hse.software.construction.database.api.model

data class Hall(
        val name: String,
        val tickets: Set<Ticket>
) {

    data class Ticket(
            val seatNumber: Int
    )
}