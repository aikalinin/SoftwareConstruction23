package ru.hse.software.construction.model

import kotlinx.serialization.Serializable

@Serializable
class Library(val books: MutableList<Book>)