package net.nfsync.nfsyncbackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Avatar {

  @Id
  @Column(name = "user_id")
  private Integer id;
  
  private byte[] image;
}
