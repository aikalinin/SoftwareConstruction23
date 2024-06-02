package org.hse.template.service

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class KafkaConsumerService {

    @KafkaListener(
        topics = ["\${system.kafka.topic}"],
        groupId = "\${spring.kafka.consumer.group-id}"
    )
    fun consume(message: String) {
        println("Consumed message: $message")
    }
}
