package ru.hse.software.construction.mvc

data class Task(val description: String)

class TaskModel {
    private val tasks = mutableListOf<Task>()

    fun addTask(task: Task) {
        tasks.add(task)
    }

    fun getTasks(): List<Task> = tasks
}
