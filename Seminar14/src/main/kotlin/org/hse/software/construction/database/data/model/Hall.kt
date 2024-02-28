package org.hse.software.construction.database.data.model

import jakarta.persistence.*
import java.util.UUID

@Entity
class Hall(
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        val id: UUID? = null,
        val name: String,
        @OneToMany(mappedBy = "hall")
        val tickets: Set<Ticket>? = null
)