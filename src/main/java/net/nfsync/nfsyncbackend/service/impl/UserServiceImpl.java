package net.nfsync.nfsyncbackend.service.impl;

import lombok.RequiredArgsConstructor;
import net.nfsync.nfsyncbackend.entity.User;
import net.nfsync.nfsyncbackend.exception.UserNotFoundException;
import net.nfsync.nfsyncbackend.repository.UserRepository;
import net.nfsync.nfsyncbackend.service.UserService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Override
  public User getUserById(Integer id) {
    return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
  }

  @Override
  public User getUserByPhoneNumber(String phoneNumber) {
    return userRepository
        .findByPhoneNumber(phoneNumber)
        .orElseThrow(() -> new UserNotFoundException(phoneNumber));
  }

  @Override
  public User saveUser(User user) {
    return userRepository.save(user);
  }

  @Override
  public void deleteUserById(Integer id) {
    User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    userRepository.delete(user);
  }
}
