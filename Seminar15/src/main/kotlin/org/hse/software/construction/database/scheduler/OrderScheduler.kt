package org.hse.software.construction.database.scheduler

import org.hse.software.construction.database.data.model.Task
import org.hse.software.construction.database.data.repository.TaskRepository
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class OrderScheduler(
        private val taskRepository: TaskRepository
) {

    @Scheduled(fixedDelay = 10000)
    fun run() {
        println("Scheduler started")
        val tasks = taskRepository.findAllByStatusIsOrderByCreatedAt(Task.Status.CREATED)
        tasks.forEach { task ->
            Thread.sleep(1000)
            taskRepository.save(task.apply {
                status = Task.Status.DONE
            })
        }
        println("Scheduler done")
    }
}