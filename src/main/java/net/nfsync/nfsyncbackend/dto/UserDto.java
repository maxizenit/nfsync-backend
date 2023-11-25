package net.nfsync.nfsyncbackend.dto;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

  private Integer id;

  private String phoneNumber;

  private String lastName;

  private String firstName;

  private String middleName;

  private Date birthdate;

  private String biography;
}
