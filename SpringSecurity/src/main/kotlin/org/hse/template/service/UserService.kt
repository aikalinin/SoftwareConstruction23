package org.hse.template.service

import org.hse.template.api.model.AuthenticationRequest
import org.hse.template.api.model.User
import org.hse.template.model.DefaultUserDetails
import org.hse.template.model.DefaultUserDetails.AuthorityType
import org.hse.template.repository.DefaultUserRepository
import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import kotlin.io.encoding.ExperimentalEncodingApi

@Service
@ExperimentalEncodingApi
class UserService(
    private val defaultUserDetailsService: DefaultUserDetailsService,
    private val defaultUserRepository: DefaultUserRepository,
    private val jwtService: JwtService,
    private val passwordEncoder: PasswordEncoder
) {

    @Transactional
    fun registerNewUser(user: User): HttpEntity<String> {
        if (defaultUserRepository.findByName(user.name) != null) {
            throw RuntimeException("User already exists")
        }

        val encodedPassword = passwordEncoder.encode(user.password)
        defaultUserRepository.save(
            DefaultUserDetails(
                name = user.name,
                password = encodedPassword,
                role = AuthorityType.valueOf(user.role)
            )
        )

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body("User registered successfully")
    }

    fun login(authenticationRequest: AuthenticationRequest): ResponseEntity<String> {
        val userDetails: UserDetails =
            defaultUserDetailsService.loadUserByUsername(authenticationRequest.username)
        val jwt = jwtService.generateToken(userDetails)

        return ResponseEntity.ok(jwt)
    }
}