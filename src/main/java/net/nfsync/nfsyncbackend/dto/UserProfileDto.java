package net.nfsync.nfsyncbackend.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserProfileDto {

  private Integer id;

  private String phoneNumber;

  private String lastName;

  private String firstName;

  private String middleName;

  private Integer age;

  private String biography;

  private List<String> interests;

  private List<String> socialLinks;
}
