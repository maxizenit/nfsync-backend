package net.nfsync.nfsyncbackend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SocialLinkDto {

  private Integer id;

  private UserDto user;

  private String url;
}
