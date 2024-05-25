package org.hse.web.socket.data

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime
import java.util.UUID

@Table
data class Chat(
    @Id
    val id: UUID? = null,

    @Pattern(regexp = "[a-zA-Z0-9]+")
    @NotBlank
    val name: String?
)

@Table
data class Message(
    @Id
    var id: UUID? = null,
    var chatId: UUID? = null,
    var messageTime: LocalDateTime? = null,
    val content: String,
    val authorName: String
)
