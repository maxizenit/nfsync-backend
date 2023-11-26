package net.nfsync.nfsyncbackend.controller;

import io.swagger.v3.oas.annotations.Operation;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import lombok.RequiredArgsConstructor;
import net.nfsync.nfsyncbackend.dto.CreateUserDto;
import net.nfsync.nfsyncbackend.dto.DetailedSelectionDto;
import net.nfsync.nfsyncbackend.dto.UserDto;
import net.nfsync.nfsyncbackend.dto.UserProfileDto;
import net.nfsync.nfsyncbackend.entity.Avatar;
import net.nfsync.nfsyncbackend.entity.Contact;
import net.nfsync.nfsyncbackend.entity.Interest;
import net.nfsync.nfsyncbackend.entity.Selection;
import net.nfsync.nfsyncbackend.entity.SocialLink;
import net.nfsync.nfsyncbackend.entity.User;
import net.nfsync.nfsyncbackend.repository.AvatarRepository;
import net.nfsync.nfsyncbackend.service.AvatarService;
import net.nfsync.nfsyncbackend.service.UserService;
import net.nfsync.nfsyncbackend.util.DateUtils;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** Контроллер для пользователей. */
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  private final AvatarService avatarService;

  private final DateUtils dateUtils;

  private final ModelMapper modelMapper;

  @Operation(summary = "Получение профиля пользователя по id")
  @GetMapping("/{id}")
  public ResponseEntity<UserProfileDto> getUserById(@PathVariable Integer id) {
    User user = userService.getUserById(id);
    return new ResponseEntity<>(convertUserToProfileDto(user), HttpStatus.OK);
  }

  private UserProfileDto convertUserToProfileDto(User user) {
    UserProfileDto userProfileDto = new UserProfileDto();
    userProfileDto.setId(user.getId());
    userProfileDto.setPhoneNumber(user.getPhoneNumber());
    userProfileDto.setLastName(user.getLastName());
    userProfileDto.setFirstName(user.getFirstName());
    userProfileDto.setMiddleName(user.getMiddleName());
    userProfileDto.setBiography(user.getBiography());

    Date birthdate = user.getBirthdate();
    if (birthdate != null) {
      LocalDate birthDateLocal = dateUtils.convertDateToLocalDate(birthdate);
      int age = dateUtils.getAgeByBirthdate(birthDateLocal);
      userProfileDto.setAge(age);
    }

    userProfileDto.setInterests(user.getInterests().stream().map(Interest::getTitle).toList());
    userProfileDto.setSocialLinks(user.getSocialLinks().stream().map(SocialLink::getUrl).toList());

    return userProfileDto;
  }

  @Operation(summary = "Получение всех профилей пользователей из контактов пользователя")
  @GetMapping("/{id}/contacts")
  public ResponseEntity<List<UserProfileDto>> getContactsByUserId(@PathVariable Integer id) {
    User subscriber = userService.getUserById(id);
    List<UserProfileDto> usersInContacts =
        subscriber.getContacts().stream()
            .map(Contact::getUser)
            .map(this::convertUserToProfileDto)
            .toList();

    return new ResponseEntity<>(usersInContacts, HttpStatus.OK);
  }

  @Operation(summary = "Получение всех подборок пользователя с профилями внутри")
  @GetMapping("/{id}/selections")
  public ResponseEntity<List<DetailedSelectionDto>> getSelectionsByUserId(
      @PathVariable Integer id) {
    User user = userService.getUserById(id);
    List<DetailedSelectionDto> detailedSelections =
        user.getSelections().stream().map(this::convertSelectionToDetailedDto).toList();

    return new ResponseEntity<>(detailedSelections, HttpStatus.OK);
  }

  private final AvatarRepository avatarRepository;

  @Operation(summary = "Получение аватара пользователя")
  @GetMapping(value = "/{id}/avatar")
  public ResponseEntity<byte[]> getAvatarByUserId(@PathVariable Integer id) {
    User user = userService.getUserById(id);
    byte[] image = avatarRepository.findById(user.getId()).get().getImage();
    return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(image);
  }

  @Operation(summary = "Сохранение аватара пользователя")
  @PostMapping("/{id}/avatar")
  public ResponseEntity<?> saveAvatarForUser(@PathVariable Integer id, @RequestBody byte[] image) {
    User user = userService.getUserById(id);

    Avatar avatar = new Avatar();
    avatar.setId(user.getId());
    avatar.setImage(image);
    avatarService.saveAvatar(avatar);

    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  private DetailedSelectionDto convertSelectionToDetailedDto(Selection selection) {
    DetailedSelectionDto detailedSelectionDto = new DetailedSelectionDto();
    detailedSelectionDto.setId(selection.getId());
    detailedSelectionDto.setTitle(selection.getTitle());
    detailedSelectionDto.setIsEvent(selection.getIsEvent());
    detailedSelectionDto.setDate(selection.getDate());
    detailedSelectionDto.setUser(modelMapper.map(selection.getUser(), UserDto.class));

    detailedSelectionDto.setParticipants(
        selection.getContacts().stream()
            .map(Contact::getUser)
            .map(this::convertUserToProfileDto)
            .toList());
    return detailedSelectionDto;
  }

  @Operation(summary = "Создание пользователя")
  @PostMapping
  public ResponseEntity<UserDto> createUser(@RequestBody CreateUserDto createUserDto) {
    User user = new User();
    user.setPhoneNumber(createUserDto.getPhoneNumber());
    user.setLastName(createUserDto.getLastName());
    user.setFirstName(createUserDto.getFirstName());
    user.setMiddleName(createUserDto.getMiddleName());
    user.setBirthdate(createUserDto.getBirthdate());
    user.setBiography(createUserDto.getBiography());

    UserDto result = modelMapper.map(userService.saveUser(user), UserDto.class);
    return new ResponseEntity<>(result, HttpStatus.CREATED);
  }

  @Operation(summary = "Удаление пользователя")
  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteUserById(@PathVariable Integer id) {
    userService.deleteUserById(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
