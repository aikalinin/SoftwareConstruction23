package org.hse.software.construction.database.controller

import org.hse.software.construction.database.data.model.Film
import org.hse.software.construction.database.data.model.Session
import org.hse.software.construction.database.data.repository.*
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class SessionController(
        val filmRepository: FilmRepository,
        val sessionRepository: SessionRepository
) {

    @PostMapping("/film/{filmId}/session")
    fun saveNewSession(
            @PathVariable("filmId") filmId: UUID,
            @RequestBody session: Session
    ): Session {
        val film = filmRepository.findById(filmId).get()
        session.film = film
        return sessionRepository.save(session)
    }
}