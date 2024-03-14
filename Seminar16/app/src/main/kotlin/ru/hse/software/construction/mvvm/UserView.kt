package ru.hse.software.construction.mvvm

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class UserView(private val userViewModel: UserViewModel) {

    fun onCreate() {
        runBlocking {
            setContentView()

            userViewModel.loadUsers()

            launch {
                userViewModel.users.collect { users ->
                    println("Users:")
                    users.forEach { println("${it.id}: ${it.name}") }
                }
            }
        }
    }

    private fun setContentView() {
        println("Set layout")
    }
}