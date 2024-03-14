package ru.hse.software.construction.mvvm

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class UserViewModel {
    private val _users = MutableStateFlow<List<User>>(emptyList())
    val users: StateFlow<List<User>> = _users

    fun loadUsers() {
        // Здесь должна быть логика загрузки пользователей, например, из репозитория
        _users.value = listOf(User(1, "Alice"), User(2, "Bob"), User(3, "Charlie"))
    }
}