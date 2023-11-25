package net.nfsync.nfsyncbackend.exception;

public class AvatarNotFoundException extends RuntimeException {

  private static final String MESSAGE = "Avatar for user with id '%d' not found";

  public AvatarNotFoundException(Integer userId) {
    super(String.format(MESSAGE, userId));
  }
}
