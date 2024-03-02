package org.hse.software.construction.database.data.model

import jakarta.persistence.*
import java.math.BigDecimal
import java.util.*

@Entity
class Ticket(
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        val id: UUID? = null,
        val localRow: Int,
        val localColumn: Int,
        val price: BigDecimal,
        @ManyToOne
        @JoinColumn(name = "session_id", nullable = false)
        val session: Session? = null,
        @ManyToOne
        @JoinColumn(name = "user_order_id", nullable = false)
        val userOrder: UserOrder? = null
)