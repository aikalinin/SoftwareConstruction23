package org.hse.template.client.rest.api

import org.hse.template.client.rest.model.Fact
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "cat-facts", path = "facts")
interface CatFactsClient {

    @GetMapping("random")
    fun random(@RequestParam("amount") amount: Int = 1): List<Fact>
}
