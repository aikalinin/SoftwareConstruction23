package org.hse.software.construction.database.data.repository

import org.hse.software.construction.database.data.model.Ticket
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface TicketRepository : JpaRepository<Ticket, UUID>