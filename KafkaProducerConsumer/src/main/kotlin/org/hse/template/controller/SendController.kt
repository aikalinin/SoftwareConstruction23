package org.hse.template.controller

import org.hse.template.service.KafkaProducerService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class SendController(
    private val kafkaProducerService: KafkaProducerService
) {

    @PostMapping("/send")
    fun send(@RequestParam("message") message: String, @RequestParam("key") key: String? = null) {
        when (key) {
            null -> kafkaProducerService.send(message)
            else -> kafkaProducerService.send(key, message)
        }
    }
}