package org.hse.software.construction.database.data.model

import jakarta.persistence.*
import java.util.*

@Entity
class Film(
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        val id: UUID? = null,
        @Column(nullable = false)
        val name: String,
        @OneToMany(mappedBy = "film", cascade = [CascadeType.REMOVE, CascadeType.MERGE])
        val sessions: Set<Session>? = null,
        @ManyToMany
        @JoinTable(
                name = "film_category",
                joinColumns = [JoinColumn(name = "film_id")],
                inverseJoinColumns = [JoinColumn(name = "category_name")]
        )
        val categories: Set<Category>
)
