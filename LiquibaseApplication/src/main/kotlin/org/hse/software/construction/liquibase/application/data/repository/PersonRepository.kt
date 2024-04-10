package org.hse.software.construction.liquibase.application.data.repository

import org.hse.software.construction.liquibase.application.data.model.Person
import org.springframework.data.repository.CrudRepository

interface PersonRepository: CrudRepository<Person, Int> {

    fun findAllByName(name: String): List<Person>
}