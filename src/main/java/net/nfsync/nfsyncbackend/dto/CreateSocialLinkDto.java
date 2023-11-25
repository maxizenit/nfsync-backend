package net.nfsync.nfsyncbackend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateSocialLinkDto {

  private Integer userId;

  private String url;
}
