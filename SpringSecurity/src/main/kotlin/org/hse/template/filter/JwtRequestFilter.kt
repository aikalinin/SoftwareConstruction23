package org.hse.template.filter

import io.jsonwebtoken.JwtException
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.hse.template.service.JwtService
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import kotlin.io.encoding.ExperimentalEncodingApi

@Component
@ExperimentalEncodingApi
class JwtRequestFilter(
    private val userDetailsService: UserDetailsService,
    private val jwtService: JwtService
): OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        chain: FilterChain
    ) {
        val authorizationHeader = request.getHeader("Authorization")
        var username: String? = null
        var jwt: String? = null

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring(7)
            username = jwtService.extractUsername(jwt)
        }

        if (username != null && SecurityContextHolder.getContext().authentication == null) {
            val userDetails = this.userDetailsService.loadUserByUsername(username)
            if (jwtService.validateToken(jwt!!, userDetails)) {
                val usernamePasswordAuthenticationToken = UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.authorities
                )

                usernamePasswordAuthenticationToken.details =
                    WebAuthenticationDetailsSource().buildDetails(request)
                SecurityContextHolder.getContext().authentication =
                    usernamePasswordAuthenticationToken
            } else {
//                response.status = HttpServletResponse.SC_UNAUTHORIZED
                throw JwtException("Invalid JWT token")
            }
        }

        chain.doFilter(request, response)
    }
}
