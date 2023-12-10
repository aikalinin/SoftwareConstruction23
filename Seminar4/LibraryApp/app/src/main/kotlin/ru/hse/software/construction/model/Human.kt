package ru.hse.software.construction.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class Human(@Transient val name: String = "", val age: Int, val password: String)
