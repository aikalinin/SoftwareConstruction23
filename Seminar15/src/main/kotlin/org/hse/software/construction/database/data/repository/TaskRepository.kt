package org.hse.software.construction.database.data.repository

import org.hse.software.construction.database.data.model.Task
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface TaskRepository: JpaRepository<Task, UUID> {

    fun findAllByStatusIsOrderByCreatedAt(status: Task.Status): List<Task>
}