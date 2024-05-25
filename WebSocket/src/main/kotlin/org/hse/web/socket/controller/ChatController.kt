package org.hse.web.socket.controller

import jakarta.validation.Valid
import org.hse.web.socket.data.Chat
import org.hse.web.socket.data.ChatRepository
import org.hse.web.socket.data.MessageRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
class ChatController(
    private val chatRepository: ChatRepository,
    private val messageRepository: MessageRepository
) {

    @PostMapping("/api/chat")
    fun createChat(@Valid @RequestBody chat: Chat): Chat {
        return chatRepository.save(chat)
    }

    @GetMapping("/api/chat/{chatId}")
    fun getChat(@PathVariable chatId: UUID) =
        chatRepository.findById(chatId)
}
