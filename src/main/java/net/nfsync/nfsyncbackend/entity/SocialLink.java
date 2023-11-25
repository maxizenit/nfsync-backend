package net.nfsync.nfsyncbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

/** Контакт. */
@Entity
@Getter
@Setter
public class SocialLink {

  /** Идентификатор. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  /** Пользователь. */
  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  /** Ссылка. */
  private String url;
}
