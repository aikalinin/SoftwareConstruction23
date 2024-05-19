package org.hse.template.controller

import org.hse.template.api.model.AuthenticationRequest
import org.hse.template.api.model.User
import org.hse.template.service.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.io.encoding.ExperimentalEncodingApi

@RestController
@RequestMapping
@ExperimentalEncodingApi
class RegisterController(
    private val userService: UserService
) {

    @PostMapping("register")
    fun register(@RequestBody user: User) = userService.registerNewUser(user)

    @PostMapping("login")
    fun login(@RequestBody authenticationRequest: AuthenticationRequest) =
        userService.login(authenticationRequest)
}