package ru.hse.software.construction.service

import ru.hse.software.construction.model.Book
import ru.hse.software.construction.model.Library
import ru.hse.software.construction.repository.FileLibraryException
import ru.hse.software.construction.repository.FileLibraryRepository
import ru.hse.software.construction.repository.LibraryRepository

class LibraryService(
    private val libraryRepository: LibraryRepository
) {

    fun saveLibrary(books: List<Book>): Library {
        // Переводим список книг в библиотеку
        val library = Library(books.toMutableList())
        libraryRepository.saveLibrary(library)
        return Library(mutableListOf())
    }
}