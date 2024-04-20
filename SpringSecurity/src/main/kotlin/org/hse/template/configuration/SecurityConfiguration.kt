package org.hse.template.configuration

import org.hse.template.service.DefaultUserDetailsService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfiguration(
    private val defaultUserDetailsService: DefaultUserDetailsService
) {

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return NoOpPasswordEncoder.getInstance()
    }

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .httpBasic(Customizer.withDefaults())
            .authorizeHttpRequests { c ->
                c
                    .requestMatchers("/admin/**").hasAuthority("ADMIN")
                    .requestMatchers("/user/**").hasAuthority("DEFAULT")
                    .requestMatchers("/", "/home", "/login").permitAll()
                    .anyRequest().authenticated()
            }
//            .formLogin { it.disable() }
            .userDetailsService(defaultUserDetailsService)

        return http.build()
    }
}