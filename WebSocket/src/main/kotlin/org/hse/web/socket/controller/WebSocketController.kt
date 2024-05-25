package org.hse.web.socket.controller

import org.hse.web.socket.data.Message
import org.hse.web.socket.data.MessageRepository
import org.hse.web.socket.model.Greeting
import org.hse.web.socket.model.HelloMessage
import org.springframework.messaging.handler.annotation.DestinationVariable
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.util.HtmlUtils
import java.time.LocalDateTime
import java.util.UUID

@Controller
class WebSocketController(
    private val messageRepository: MessageRepository
) {

    @MessageMapping("/message")
    @SendTo("/chat/send")
    fun chatting(message: HelloMessage): Greeting {
        return Greeting("Hello, " + HtmlUtils.htmlEscape(message.name) + "!")
    }

    @MessageMapping("/{id}/message")
    @SendTo("/chat/{id}/send")
    fun messaging(
        @DestinationVariable id: UUID,
        message: Message
    ) = messageRepository.save(message.apply {
        chatId = id
        messageTime = LocalDateTime.now()
    })

    @GetMapping("clear")
    fun clear() = "clear"

    @GetMapping("broker")
    fun broker() = "broker"

    @GetMapping("connectChat")
    fun connectChat() = "connectChat"

    @GetMapping("createChat")
    fun createChat() = "createChat"

    @GetMapping("getChat")
    fun getChat() = "getChat"
}
