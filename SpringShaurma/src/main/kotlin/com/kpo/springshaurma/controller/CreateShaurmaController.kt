package com.kpo.springshaurma.controller

import com.kpo.springshaurma.model.Order
import com.kpo.springshaurma.model.Shaurma
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import com.kpo.springshaurma.service.ServiceSample

@Controller
@RequestMapping("/order")
class CreateShaurmaController(
        private val serviceSample: ServiceSample
) {

    private val logger = LoggerFactory.getLogger(javaClass)

    @ModelAttribute
    fun addDataToModel(model: Model) {
        serviceSample.modifyModel(model)
    }

    @ModelAttribute(name = "order")
    fun order() = Order()

    @ModelAttribute(name = "shaurma")
    fun shaurma() = Shaurma()

    @GetMapping
    fun getForm() = "shaurma"

    @PostMapping
    fun createShaurma(shaurma: Shaurma, @ModelAttribute order: Order): String {
        order.addShaurma(shaurma)

        if (logger.isDebugEnabled) {
            logger.debug("Added shaurma {}", shaurma)
        }

        return "redirect:/orders/current"
    }
}
