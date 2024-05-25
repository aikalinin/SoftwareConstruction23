package org.hse.web.socket.data

import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface ChatRepository: CrudRepository<Chat, UUID>
