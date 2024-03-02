package org.hse.software.construction.database.data.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany

@Entity
class Category(
        @Id
        val name: String,
        @ManyToMany(mappedBy = "categories")
        val films: Set<Film>? = null
)