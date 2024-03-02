package org.hse.software.construction.database.data.repository

import org.hse.software.construction.database.data.model.*
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface FilmRepository : JpaRepository<Film, UUID> {

    override fun findAll(pageable: Pageable): Page<Film>
}

interface HallRepository : JpaRepository<Hall, UUID> {
}

interface UserOrderRepository : JpaRepository<UserOrder, UUID> {
}

interface SessionRepository : JpaRepository<Session, UUID> {
}

interface TicketRepository : JpaRepository<Ticket, UUID> {
}