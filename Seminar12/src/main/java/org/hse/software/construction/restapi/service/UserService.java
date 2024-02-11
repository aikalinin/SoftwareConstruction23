package org.hse.software.construction.restapi.service;

import java.util.List;
import java.util.UUID;
import org.hse.software.construction.restapi.model.User;

public interface UserService {

  User createUser(User user);

  User getUserById(UUID id);

  List<User> getUserByName(String name);
}
