package net.nfsync.nfsyncbackend.exception;

/** Сигнализирует о том, что пользователь не найден. */
public class UserNotFoundException extends RuntimeException {

  private static final String MESSAGE_FOR_ID = "User with id '%d' not found";

  private static final String MESSAGE_FOR_PHONE_NUMBER = "User with username '%s' not found";

  public UserNotFoundException(Integer userId) {
    super(String.format(MESSAGE_FOR_ID, userId));
  }

  public UserNotFoundException(String phoneNumber) {
    super(String.format(MESSAGE_FOR_PHONE_NUMBER, phoneNumber));
  }
}
