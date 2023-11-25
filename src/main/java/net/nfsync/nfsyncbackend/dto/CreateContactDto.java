package net.nfsync.nfsyncbackend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateContactDto {

  private Integer userId;

  private Integer subscriberId;
}
