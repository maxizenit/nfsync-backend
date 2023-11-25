package net.nfsync.nfsyncbackend.dto;

import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetailedSelectionDto {

  private Integer id;

  private UserDto user;

  private String title;

  private Boolean isEvent;

  private Date date;

  List<UserProfileDto> participants;
}
