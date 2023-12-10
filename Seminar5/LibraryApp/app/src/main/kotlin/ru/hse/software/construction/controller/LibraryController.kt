package ru.hse.software.construction.controller

import ru.hse.software.construction.converter.LibraryConverter
import ru.hse.software.construction.reader.UserReader
import ru.hse.software.construction.service.LibraryService

class LibraryController(
    private val userReader: UserReader,
    private val libraryService: LibraryService,
    private val libraryConverter: LibraryConverter
) {

    fun createLibrary() {
        try {
            val books = userReader.readStringBooks()
            // Здесь валидируем то, что ввёл пользователь throw IncorrectInput
            // Можно назвать parser
            libraryService.saveLibrary(libraryConverter.convert(books))
        } catch (ex: Exception) {
            //userPrinter.printUserError(ex)
        }
    }
}