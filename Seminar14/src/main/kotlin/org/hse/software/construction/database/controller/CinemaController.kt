package org.hse.software.construction.database.controller

import org.hse.software.construction.database.api.model.Hall
import org.hse.software.construction.database.data.model.Ticket
import org.hse.software.construction.database.data.repository.HallRepository
import org.hse.software.construction.database.data.repository.TicketRepository
import org.springframework.web.bind.annotation.*

@RestController
class CinemaController(
        private val hallRepository: HallRepository,
        private val ticketRepository: TicketRepository
) {

    @PostMapping("hall")
    fun createHall(@RequestBody hall: Hall) {
        val savedHall = hallRepository.save(
                org.hse.software.construction.database.data.model.Hall(
                        name = hall.name
                )
        )

        hall.tickets.forEach {
            ticketRepository.save(Ticket(
                    seatNumber = it.seatNumber,
                    hall = savedHall
            ))
        }
    }

    @GetMapping("hall/{hallName}")
    fun getHall(@PathVariable hallName: String) =
            hallRepository.findHallByName(hallName).map {
                Hall(
                        name = it.name,
                        tickets = it.tickets?.map {
                            Hall.Ticket(
                                    seatNumber = it.seatNumber
                            )
                        }?.toSet() ?: emptySet()
                )
            }
}