package org.hse.software.construction.restapi.controller;

import java.util.List;
import java.util.UUID;
import org.hse.software.construction.restapi.model.User;
import org.hse.software.construction.restapi.service.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  private final UserService userService;

  public UserController(@Qualifier("defaultUserService") UserService userService) {
    this.userService = userService;
  }

  @PostMapping("user")
  public User createUser(@RequestBody User user) {
    return userService.createUser(user);
  }

  @GetMapping("/user/{id}")
  public User getUserById(@PathVariable String id) {
    return userService.getUserById(UUID.fromString(id));
  }

  @GetMapping("/user")
  public List<User> getUserByName(@RequestParam String name) {
    return userService.getUserByName(name);
  }
}
