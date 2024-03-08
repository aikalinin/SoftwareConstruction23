package org.hse.software.construction.coroutines

import kotlinx.coroutines.*

fun main(args: Array<String>) {
    GlobalScope.async {
        printer()
    }

    Thread.sleep(1000)
}

suspend fun printer(): String {
    println("!!!")
    return "Result"
}
