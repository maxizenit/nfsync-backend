package net.nfsync.nfsyncbackend.service;

import net.nfsync.nfsyncbackend.entity.User;

/** Сервис для работы с пользователями. */
public interface UserService {

  /**
   * Возвращает пользователя с заданным идентификатором.
   *
   * @param id идентификатор
   * @return пользователь с заданным идентификатором
   */
  User getUserById(Integer id);

  /**
   * Возвращает пользователя с заданным номером телефона.
   *
   * @param phoneNumber идентификатор
   * @return пользователь с заданным номером телефона
   */
  User getUserByPhoneNumber(String phoneNumber);

  User saveUser(User user);

  /**
   * Удаляет пользователя с заданным идентификатором.
   *
   * @param id идентификатор
   */
  void deleteUserById(Integer id);
}
