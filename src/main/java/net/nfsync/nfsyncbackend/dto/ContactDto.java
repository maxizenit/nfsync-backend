package net.nfsync.nfsyncbackend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactDto {

  private Integer id;

  private UserDto user;

  private UserDto subscriber;
}
