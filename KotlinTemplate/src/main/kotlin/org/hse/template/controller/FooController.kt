package org.hse.template.controller

import org.hse.template.api.FooApi
import org.hse.template.client.rest.api.CatFactsClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class FooController(
    private val catFactsClient: CatFactsClient
) : FooApi {

    @GetMapping
    override fun foo(@RequestParam amount: Int) = catFactsClient.random(amount)
}