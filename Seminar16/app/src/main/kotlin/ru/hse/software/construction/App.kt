package ru.hse.software.construction

import ru.hse.software.construction.mvc.TaskController
import ru.hse.software.construction.mvc.TaskModel
import ru.hse.software.construction.mvc.TaskView
import ru.hse.software.construction.mvp.User
import ru.hse.software.construction.mvp.UserPresenter
import ru.hse.software.construction.mvp.UserRepository
import ru.hse.software.construction.mvp.UserView

fun main() {
    // MVC
    val model = TaskModel()
    val view = TaskView()
    // Если бы мы хотели получить пользователя, то запрос в БД/сервис кинули через Controller
    val controller = TaskController(model, view)

    controller.addTask("Изучить Kotlin")
    controller.addTask("Написать приложение на Kotlin")
    controller.displayTasks()

    // MVP
    // Эмуляция репозитория
    val userRepository = object : UserRepository {
        override fun getUsers(): List<User> {
            return listOf(User(1, "Vasya"), User(2, "Andrey"), User(3, "Max"))
        }
    }

    // Эмуляция View
    val userView = object : UserView {
        override fun showUsers(users: List<User>) {
            println("Users:")
            users.forEach { println("${it.id}: ${it.name}") }
        }

        override fun showError(message: String) {
            println("Error: $message")
        }
    }

    val presenter = UserPresenter(userView, userRepository)
    presenter.onViewCreated()
}