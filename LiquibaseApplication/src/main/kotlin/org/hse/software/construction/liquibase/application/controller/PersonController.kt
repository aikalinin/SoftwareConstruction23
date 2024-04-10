package org.hse.software.construction.liquibase.application.controller

import org.hse.software.construction.liquibase.application.data.repository.PersonRepository
import org.springframework.data.repository.query.Param
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PersonController(val personRepository: PersonRepository) {

    @GetMapping
    fun getPersonsByName(@Param("name") name: String) = personRepository.findAllByName(name)
}
