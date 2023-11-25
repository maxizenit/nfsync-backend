package net.nfsync.nfsyncbackend.dto;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateSelectionDto {

  private Integer userId;

  private String title;

  private Boolean isEvent;

  private Date date;
}
