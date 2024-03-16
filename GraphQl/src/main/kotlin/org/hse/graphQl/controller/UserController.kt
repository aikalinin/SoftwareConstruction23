package org.hse.graphQl.controller

import org.hse.graphQl.model.User
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller
import java.util.*

@Controller
class UserController {

    private val users: MutableMap<String, User> = mutableMapOf()

    @QueryMapping
    fun findUserById(@Argument id: String): User? = users[id]

    @QueryMapping
    fun findUsersByName(@Argument name: String): List<User> = users
            .values
            .filter { it.name == name }

    @QueryMapping
    fun findAllUsers(): List<User> = users.values.toList()

    @MutationMapping
    fun createUser(@Argument name: String, @Argument email: String?): User {
        val userId = UUID.randomUUID().toString()
        return User(
                id = userId,
                name = name,
                email = email
        ).also {
            users[userId] = it
        }
    }
}