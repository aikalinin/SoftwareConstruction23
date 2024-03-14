package ru.hse.software.construction.mvc

class TaskController(private val model: TaskModel, private val view: TaskView) {
    fun addTask(description: String) {
        val task = Task(description)
        model.addTask(task)
        view.displayTaskAdded(task)
    }

    fun displayTasks() {
        val tasks = model.getTasks()
        view.displayTasks(tasks)
    }
}