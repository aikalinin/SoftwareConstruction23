package org.hse.software.construction.database.data.model

import jakarta.persistence.*
import java.util.UUID

@Entity
class Hall(
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        val id: UUID? = null,
        val localRows: Int,
        val localColumns: Int,
        @OneToMany(mappedBy = "hall")
        val sessions: Set<Session>? = null
)