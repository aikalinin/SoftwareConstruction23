package ru.hse.software.construction.mvp

data class User(val id: Int, val name: String)

interface UserRepository {
    fun getUsers(): List<User>
}