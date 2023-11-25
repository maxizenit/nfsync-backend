package net.nfsync.nfsyncbackend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactInSelectionDto {

  private Integer id;

  private SelectionDto selection;

  private ContactDto contact;
}
