package org.hse.software.construction.database.data.repository

import org.hse.software.construction.database.data.model.Hall
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface HallRepository: JpaRepository<Hall, UUID> {

    fun findHallByName(name: String): List<Hall>
}
