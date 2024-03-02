package org.hse.software.construction.database.data.model

import jakarta.persistence.*
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDateTime
import java.util.*

@Entity
class Session(
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        val id: UUID? = null,
        val dateTime: LocalDateTime? = null,
        @ManyToOne
        @JoinColumn(name = "film_id", nullable = false)
        var film: Film? = null,
        @ManyToOne
        @JoinColumn(name = "hall_id", nullable = false)
        val hall: Hall? = null,
        @OneToMany(mappedBy = "session")
        val tickets: Set<Ticket>? = null,
        @OneToMany(mappedBy = "session")
        val userOrders: Set<UserOrder>? = null
)
