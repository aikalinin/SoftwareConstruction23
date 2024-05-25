package org.hse.web.socket.service

import org.springframework.http.HttpStatus.BAD_REQUEST
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice("org.hse.web.socket.data")
class ExceptionService {

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(
        RuntimeException::class
    )
    fun handleError(
        ex: RuntimeException
    ): Map<String, String> {
        ;
        val errors: MutableMap<String, String> = HashMap()
        return errors
    }
}