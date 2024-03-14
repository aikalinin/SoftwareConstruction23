package com.kpo.springshaurma.controller;

import com.kpo.springshaurma.model.Order;
import com.kpo.springshaurma.model.Shaurma;
import com.kpo.springshaurma.service.ServiceSample;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/order")
@RequiredArgsConstructor
public class CreateShaurmaController {

  private final ServiceSample serviceSample;

  @ModelAttribute
  public void addDataToModel(Model model) {
    serviceSample.modifyModel(model);
  }

  @ModelAttribute(name = "order")
  public Order order() {
    return new Order();
  }

  @ModelAttribute(name = "shaurma")
  public Shaurma shaurma() {
    return new Shaurma();
  }

  @GetMapping
  public String getForm() {
    return "shaurma";
  }

  @PostMapping
  public String createShaurma(Shaurma shaurma, @ModelAttribute Order order) {
    order.addShaurma(shaurma);

    if (log.isDebugEnabled()) {
      log.debug("Added shaurma {}", shaurma);
    }

    return "redirect:/orders/current";
  }
}
