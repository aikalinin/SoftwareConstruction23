package ru.hse.software.construction

import ru.hse.software.construction.controller.LibraryController
import ru.hse.software.construction.converter.LibraryConverter
import ru.hse.software.construction.model.Book
import ru.hse.software.construction.model.Human
import ru.hse.software.construction.reader.UserReader
import ru.hse.software.construction.repository.FileLibraryRepository
import ru.hse.software.construction.repository.LibraryRepository
import ru.hse.software.construction.service.LibraryService

fun main(args: Array<String>) {
    val human = Human("Vasya", 18, "")
    human.method()
    val string = Json.encodeToJsonElement(human).toString()
    LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS)
    File("person1").writeText(string)
    val deserializedHuman = Json.decodeFromString<Human>(File("person1").readText())

    println(deserializedHuman)

    val inputPassword = passwordReader.readPassword() // <- MD5()
    val human = Human("a", 22, inputPassword)

    var bookList = mutableListOf(Book("name", "author"))
    val list = mutableListOf("a")
    list += "b"
    println(list)
}
