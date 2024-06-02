package org.hse.template.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class KafkaProducerService(
    private val kafkaTemplate: KafkaTemplate<String, Message>,
    @Value("\${system.kafka.topic}")
    private val topicName: String
) {

    fun send(key: String, message: String) {
        kafkaTemplate.send(
            topicName, key, Message(
                author = "Vasya",
                message = message
            )
        )
    }

    fun send(message: String) {
        kafkaTemplate.send(
            topicName, Message(
                author = "Vasya",
                message = message
            )
        )
    }

    data class Message(
        val author: String,
        val message: String
    )
}