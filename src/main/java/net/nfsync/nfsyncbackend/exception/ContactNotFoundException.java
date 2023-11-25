package net.nfsync.nfsyncbackend.exception;

public class ContactNotFoundException extends RuntimeException {

  private static final String MESSAGE = "Contact with id '%d' not found";

  public ContactNotFoundException(Integer contactId) {
    super(String.format(MESSAGE, contactId));
  }
}
