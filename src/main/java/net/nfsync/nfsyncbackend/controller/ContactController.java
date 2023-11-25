package net.nfsync.nfsyncbackend.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import net.nfsync.nfsyncbackend.dto.ContactDto;
import net.nfsync.nfsyncbackend.dto.CreateContactDto;
import net.nfsync.nfsyncbackend.entity.Contact;
import net.nfsync.nfsyncbackend.service.ContactService;
import net.nfsync.nfsyncbackend.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contacts")
@RequiredArgsConstructor
public class ContactController {

  private final ContactService contactService;

  private final UserService userService;

  private final ModelMapper modelMapper;

  @Operation(summary = "Создание контакта для пользователя")
  @PostMapping
  public ResponseEntity<ContactDto> createContactForUser(
      @RequestBody CreateContactDto createContactDto) {
    Contact contact = new Contact();
    contact.setUser(userService.getUserById(createContactDto.getUserId()));
    contact.setSubscriber(userService.getUserById(createContactDto.getSubscriberId()));

    ContactDto result = modelMapper.map(contactService.saveContact(contact), ContactDto.class);
    return new ResponseEntity<>(result, HttpStatus.CREATED);
  }
}
