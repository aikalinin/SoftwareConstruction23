package ru.hse.software.construction.mvc

class TaskView {
    fun displayTasks(tasks: List<Task>) {
        tasks.forEachIndexed { index, task ->
            println("${index + 1}: ${task.description}")
        }
    }

    fun displayTaskAdded(task: Task) {
        println("Задача добавлена: ${task.description}")
    }
}