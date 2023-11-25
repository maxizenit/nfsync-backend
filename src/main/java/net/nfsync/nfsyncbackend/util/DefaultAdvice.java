package net.nfsync.nfsyncbackend.util;

import net.nfsync.nfsyncbackend.exception.AvatarNotFoundException;
import net.nfsync.nfsyncbackend.exception.ContactNotFoundException;
import net.nfsync.nfsyncbackend.exception.SelectionNotFoundException;
import net.nfsync.nfsyncbackend.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DefaultAdvice {

  @ExceptionHandler({
    UserNotFoundException.class,
    SelectionNotFoundException.class,
    ContactNotFoundException.class,
    AvatarNotFoundException.class
  })
  public ResponseEntity<String> handleNotFoundException(Exception e) {
    return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
  }
}
