package net.nfsync.nfsyncbackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Avatar {

  @Id
  @Column(name = "user_id")
  private Integer id;

  @OneToOne
  @MapsId
  @JoinColumn(name = "user_id")
  private User user;

  private byte[] image;
}
