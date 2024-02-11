package org.hse.software.construction.restapi.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.hse.software.construction.restapi.model.User;
import org.springframework.stereotype.Service;

@Service
public class DefaultUserService implements UserService {

  private final Map<UUID, User> userStorage = new HashMap<>();

  @Override
  public User createUser(User user) {
    final UUID userId = UUID.randomUUID();
    user.setId(userId);
    userStorage.put(userId, user);

    return user;
  }

  @Override
  public User getUserById(UUID id) {
    return userStorage.get(id);
  }

  @Override
  public List<User> getUserByName(String name) {
    return userStorage
        .values()
        .stream()
        .filter(user -> user.getName().equals(name))
        .toList();
  }
}
