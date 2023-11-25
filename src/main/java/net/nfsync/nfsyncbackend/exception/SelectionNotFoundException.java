package net.nfsync.nfsyncbackend.exception;

public class SelectionNotFoundException extends RuntimeException {

  private static final String MESSAGE = "Selection with id '%d' not found";

  public SelectionNotFoundException(Integer selectionId) {
    super(String.format(MESSAGE, selectionId));
  }
}
