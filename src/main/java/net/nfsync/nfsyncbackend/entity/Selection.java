package net.nfsync.nfsyncbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import java.util.Date;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

/** Подборка пользователей. */
@Entity
@Getter
@Setter
public class Selection {

  /** Идентификатор. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  /** Пользователь, создавший подборку. */
  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  /** Название. */
  private String title;

  /** Является ли мероприятием. */
  private Boolean isEvent;

  /** Дата проведения (для мероприятия). */
  private Date date;

  /** Контакты. */
  @ManyToMany(mappedBy = "selections")
  private Set<Contact> contacts;
}
