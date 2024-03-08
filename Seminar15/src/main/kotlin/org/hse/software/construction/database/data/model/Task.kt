package org.hse.software.construction.database.data.model

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime
import java.util.*

@Entity
class Task(
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        val id: UUID? = null,
        @Enumerated(EnumType.STRING)
        var status: Status,
        val createdAt: LocalDateTime? = null
) {

    enum class Status {
        CREATED,
        DONE
    }
}