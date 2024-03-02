package org.hse.software.construction.database.controller

import org.hse.software.construction.database.data.model.Film
import org.hse.software.construction.database.data.repository.*
import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class FilmController(
        val filmRepository: FilmRepository
) {

    @GetMapping("film")
    fun getAllFilms(
            @RequestParam pageNumber: Int,
            @RequestParam pageSize: Int,
    ) = filmRepository.findAll(PageRequest.of(pageNumber, pageSize))

    @PostMapping("film")
    fun saveNewFilm(
            @RequestBody film: Film
    ) = filmRepository.save(film)

    @GetMapping("/film/{filmId}")
    fun getFilm(
            @PathVariable("filmId") filmId: UUID
    ) = filmRepository.getReferenceById(filmId)

    @DeleteMapping("/film/{filmId}")
    fun deleteFilm(
            @PathVariable("filmId") filmId: UUID
    ) = filmRepository.deleteById(filmId)
}