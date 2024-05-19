package org.hse.template.api.model

data class User(
    val name: String,
    val password: String,
    val role: String
)

data class AuthenticationRequest(
    val username: String,
    val password: String
)
