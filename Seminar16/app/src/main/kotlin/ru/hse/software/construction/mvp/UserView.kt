package ru.hse.software.construction.mvp

interface UserView {
    fun showUsers(users: List<User>)
    fun showError(message: String)
}