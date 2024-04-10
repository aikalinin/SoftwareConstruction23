package org.hse.software.construction.liquibase.application.data.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("person")
class Person(
    @Id
    @Column("id")
    var id: Int,
    @Column("name")
    var name: String,
    var address: String? = null
)
