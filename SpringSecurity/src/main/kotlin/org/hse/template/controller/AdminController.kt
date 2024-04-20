package org.hse.template.controller

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("admin")
class AdminController {

    @GetMapping
    fun hello() = "Hello World"

    @GetMapping("name")
    fun name() = "Hello World, ${SecurityContextHolder.getContext().authentication.name}"
}