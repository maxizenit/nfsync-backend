package net.nfsync.nfsyncbackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/** Интерес. */
@Entity
@Getter
@Setter
public class Interest {

  /** Идентификатор. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  /** Пользователь. */
  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  /** Название. */
  private String title;
}
