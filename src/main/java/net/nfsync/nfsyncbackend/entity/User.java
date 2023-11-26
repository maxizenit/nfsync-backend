package net.nfsync.nfsyncbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/** Пользователь. */
@Entity
@Table(name = "nfsync_user")
@Getter
@Setter
public class User {

  /** Идентификатор. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  /** Номер телефона. */
  private String phoneNumber;

  /** Фамилия. */
  private String lastName;

  /** Имя. */
  private String firstName;

  /** Отчество. */
  private String middleName;

  /** Дата рождения. */
  private Date birthdate;

  /** Биография. */
  private String biography;

  /** Интересы. */
  @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
  private List<Interest> interests;

  /** Ссылки на социальные сети. */
  @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
  private List<SocialLink> socialLinks;

  /** Подборки. */
  @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
  private List<Selection> selections;

  /** Контакты. */
  @OneToMany(mappedBy = "subscriber", fetch = FetchType.LAZY)
  private List<Contact> contacts;
}
