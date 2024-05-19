package org.hse.template.configuration

import org.hse.template.filter.JwtRequestFilter
import org.hse.template.service.DefaultUserDetailsService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import kotlin.io.encoding.ExperimentalEncodingApi

@Configuration
@ExperimentalEncodingApi
class SecurityConfiguration(
    private val defaultUserDetailsService: DefaultUserDetailsService,
    private val jwtRequestFilter: JwtRequestFilter
) {

    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf { it.disable() }
            .authorizeHttpRequests { c ->
                c
                    .requestMatchers("/admin/**").hasAuthority("ADMIN")
                    .requestMatchers("/user/**").hasAuthority("DEFAULT")
                    .requestMatchers("/", "/home", "/login", "/register").permitAll()
                    .anyRequest().authenticated()
            }
            .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter::class.java)
//            .formLogin {}
            .userDetailsService(defaultUserDetailsService)

        return http.build()
    }
}