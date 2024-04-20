package org.hse.template.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class FooController {

    @GetMapping("/hello")
    fun foo(@RequestParam name: String) = "Hello Foo $name"

    @GetMapping("/")
    fun hello() = "Hello World"
}