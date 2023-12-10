package ru.hse.software.construction.repository

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToJsonElement
import ru.hse.software.construction.model.Library
import java.io.File

class FileLibraryException(
    filePath: String,
    override val message: String? = null,
    cause: Throwable? = null
) : RuntimeException("Problem with file $filePath\n$message", cause)

interface LibraryRepository {
    fun saveLibrary(library: Library)
}

class DbLibraryRepository: LibraryRepository {
    override fun saveLibrary(library: Library) {
        println("Save")
    }
}

class FileLibraryRepository(
    path: String,
    fileName: String
) : LibraryRepository {

    private val filePath = "$path/$fileName"
    private val file = File(filePath)

    override fun saveLibrary(library: Library) {
        try {
            file.writeText(Json.encodeToJsonElement(library).toString())
        } catch (ex: Throwable) {
            throw FileLibraryException(filePath, "Can't save library", ex)
        }
    }
}