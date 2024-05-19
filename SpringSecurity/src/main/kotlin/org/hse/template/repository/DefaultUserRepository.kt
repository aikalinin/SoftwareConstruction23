package org.hse.template.repository

import org.hse.template.model.DefaultUserDetails
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface DefaultUserRepository : CrudRepository<DefaultUserDetails, UUID> {

    fun findByName(name: String): DefaultUserDetails?
}
