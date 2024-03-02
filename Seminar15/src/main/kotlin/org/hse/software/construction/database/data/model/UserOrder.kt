package org.hse.software.construction.database.data.model

import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.*

@Entity
class UserOrder(
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        val id: UUID? = null,
        val dateTime: LocalDateTime,
        @ManyToOne
        @JoinColumn(name = "session_id", nullable = false)
        val session: Session? = null,
        @OneToMany(mappedBy = "userOrder")
        val tickets: Set<Ticket>? = null
)
