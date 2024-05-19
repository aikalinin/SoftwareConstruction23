package org.hse.template.service

import org.hse.template.repository.DefaultUserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class DefaultUserDetailsService(
    private val defaultUserRepository: DefaultUserRepository
) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails =
        defaultUserRepository.findByName(username)
            ?: throw UsernameNotFoundException("User $username not found")
}