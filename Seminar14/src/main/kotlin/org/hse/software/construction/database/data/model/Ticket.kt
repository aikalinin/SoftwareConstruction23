package org.hse.software.construction.database.data.model

import jakarta.persistence.*
import java.util.*

@Entity
class Ticket(
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        val id: UUID? = null,
        val seatNumber: Int,
        @ManyToOne
        @JoinColumn(name = "hall_id", nullable = false)
        val hall: Hall
)