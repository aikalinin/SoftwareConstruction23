package org.hse.software.construction.database.scheduler

import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.util.logging.Logger

@Component
class CinemaScheduler {

    @Scheduled(fixedDelay = 1000)
    fun run() {
        // crate table order ( ... state )
        // findAllByStateCreatedOrderByCreatedAt -> List<Order> (state = CREATED)
        // state = IN_PROCESS
        // forEach Order delay(time)
        // when completed state = COMPLETED
        // Notify user that order completed
        logger.info("Scheduler")
    }

    companion object {
        val logger: Logger = Logger.getLogger(CinemaScheduler::class.qualifiedName)
    }
}