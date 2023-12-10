package ru.hse.software.construction

import ru.hse.software.construction.controller.LibraryController
import ru.hse.software.construction.converter.LibraryConverter
import ru.hse.software.construction.model.Book
import ru.hse.software.construction.model.Human
import ru.hse.software.construction.reader.UserReader
import ru.hse.software.construction.repository.FileLibraryRepository
import ru.hse.software.construction.repository.LibraryRepository
import ru.hse.software.construction.service.LibraryService

fun pathValidator(arg: String) {

}

fun main(args: Array<String>) {
    val human = Human("Vasya", 18, "")
//    human.method()
//    val string = Json.encodeToJsonElement(human).toString()
//    LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS)
//    File("person1").writeText(string)
//    val deserializedHuman = Json.decodeFromString<Human>(File("person1").readText())

//    println(deserializedHuman)

//    val inputPassword = passwordReader.readPassword() // <- MD5()
//    val human = Human("a", 22, inputPassword)

    var bookList = mutableListOf(Book("name", "author"))
    val list = mutableListOf("a")
    list += "b"
    println(list)

    val value = Status.OK
    val t = when (value) {
        Status.OK -> {
            "All were okey"
        }
        Status.ERROR -> {
            "Bad"
        }
    }

    println("Before")
    val parent: Parent = A()
    println("A was created")
    A.staticA()
    println("A was called ")
    val str = when (parent) {
        is A -> parent.methodFromA()
        is B -> "B"
        else -> throw IllegalStateException("")
    }

//    for () {
//        if (OK) {
//
//        } else {
//
//        }
//    }
//    when (parent) {
//        is OK ->
//        is NOT_OK -> when(input) {
//
//        }
//    }

    val result = when (str) {
        is Unit -> "Unit"
        is String -> str
        else -> "Nothing"
    }

    println(result.uppercase())
}

class ObjectContainer {

    val objectMap: MutableMap<String, Any> = mutableMapOf()

    fun start(args: Array<String>) {
        pathValidator(args[1])
        val libraryRepository: LibraryRepository = FileLibraryRepository(args[1], "")
        val libraryService = LibraryService(libraryRepository)
        val userReader = UserReader()
        val libraryConverter = LibraryConverter()
        val libraryController = LibraryController(userReader, libraryService, libraryConverter)

        objectMap[LIBRARY_REPOSITORY_NAME] = libraryRepository
    }

    fun getObject(key: String) = objectMap[key]

    companion object {
        const val LIBRARY_REPOSITORY_NAME = "LIBRARY_REPOSITORY"
    }
}

enum class Status {
    OK, ERROR
}

abstract class Parent {

}

class A: Parent() {

    fun methodFromA() {

    }

    companion object {

        init {
            println("companion object")
        }

        fun staticA() {

        }

        const val CONST_VALUE = "a"
    }
}

class B : Parent() {

    fun methodFromB() {

    }
}
