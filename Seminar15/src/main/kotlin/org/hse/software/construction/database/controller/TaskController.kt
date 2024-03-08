package org.hse.software.construction.database.controller

import org.hse.software.construction.database.data.model.Task
import org.hse.software.construction.database.data.repository.TaskRepository
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TaskController(
        private val taskRepository: TaskRepository
) {

    @PostMapping("/task/create")
    fun create() = taskRepository.save(Task(status = Task.Status.CREATED))
}