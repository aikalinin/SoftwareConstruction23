package org.hse.web.socket.configuration

import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Configuration
import org.springframework.web.socket.CloseStatus
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.config.annotation.EnableWebSocket
import org.springframework.web.socket.config.annotation.WebSocketConfigurer
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry
import org.springframework.web.socket.handler.TextWebSocketHandler

@Configuration
@EnableWebSocket
class WebSocketConfig : WebSocketConfigurer {

    override fun registerWebSocketHandlers(registry: WebSocketHandlerRegistry) {
        registry.addHandler(MyWebSocketHandler(), "/clear-socket")
            .setAllowedOrigins("*")
    }
}

class MyWebSocketHandler : TextWebSocketHandler() {

    override fun handleTextMessage(session: WebSocketSession, message: TextMessage) {
        val payload = message.payload
        logger.info("Received message: $payload")
        session.sendMessage(TextMessage("Hello client!"))
    }

    override fun afterConnectionEstablished(session: WebSocketSession) {
        logger.info("Connection created")
    }

    override fun afterConnectionClosed(session: WebSocketSession, status: CloseStatus) {
        logger.info("Connection closed")
    }

//    private val sessions: MutableSet<WebSocketSession> = Collections.synchronizedSet(mutableSetOf())
//
//    // Thread a
//    // Thread b
//    override fun handleTextMessage(session: WebSocketSession, message: TextMessage) {
//        val payload = message.payload
//        logger.info("Received message: $payload")
//        broadcastMessage(payload)
//    }
//
//    override fun afterConnectionEstablished(session: WebSocketSession) {
//        sessions.add(session)
//        logger.info("Connection created")
//    }
//
//    override fun afterConnectionClosed(session: WebSocketSession, status: CloseStatus) {
//        sessions.remove(session)
//        logger.info("Connection closed")
//    }
//
//    private fun broadcastMessage(message: String) {
//        synchronized(sessions) {
//            for (session in sessions) {
//                try {
//                    session.sendMessage(TextMessage(message))
//                } catch (e: Exception) {
//                    e.printStackTrace()
//                }
//            }
//        }
//    }

    private companion object {
        private val logger = LoggerFactory.getLogger(MyWebSocketHandler::class.java)
    }
}