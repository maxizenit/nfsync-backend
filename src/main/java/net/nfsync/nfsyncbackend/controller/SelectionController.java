package net.nfsync.nfsyncbackend.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import net.nfsync.nfsyncbackend.dto.ContactInSelectionDto;
import net.nfsync.nfsyncbackend.dto.CreateSelectionDto;
import net.nfsync.nfsyncbackend.dto.SelectionDto;
import net.nfsync.nfsyncbackend.entity.Contact;
import net.nfsync.nfsyncbackend.entity.ContactInSelection;
import net.nfsync.nfsyncbackend.entity.Selection;
import net.nfsync.nfsyncbackend.service.ContactInSelectionService;
import net.nfsync.nfsyncbackend.service.ContactService;
import net.nfsync.nfsyncbackend.service.SelectionService;
import net.nfsync.nfsyncbackend.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/selections")
@RequiredArgsConstructor
public class SelectionController {

  private final SelectionService selectionService;

  private final ContactService contactService;

  private final ContactInSelectionService contactInSelectionService;

  private final UserService userService;

  private final ModelMapper modelMapper;

  @Operation(summary = "Создание подборки для пользователя")
  @PostMapping
  public ResponseEntity<SelectionDto> createSelectionForUser(
      @RequestBody CreateSelectionDto createSelectionDto) {
    Selection selection = new Selection();
    selection.setUser(userService.getUserById(createSelectionDto.getUserId()));
    selection.setTitle(createSelectionDto.getTitle());
    selection.setIsEvent(createSelectionDto.getIsEvent());
    selection.setDate(createSelectionDto.getDate());

    SelectionDto result =
        modelMapper.map(selectionService.saveSelection(selection), SelectionDto.class);
    return new ResponseEntity<>(result, HttpStatus.CREATED);
  }

  @Operation(summary = "Добавление контакта в подборку")
  @PostMapping("/{id}/add-contact/{contactId}")
  public ResponseEntity<ContactInSelectionDto> addContactInSelection(
      @PathVariable Integer id, @PathVariable Integer contactId) {
    Selection selection = selectionService.getSelectionById(id);
    Contact contact = contactService.getContactById(contactId);

    ContactInSelection contactInSelection = new ContactInSelection();
    contactInSelection.setSelection(selection);
    contactInSelection.setContact(contact);

    ContactInSelectionDto result =
        modelMapper.map(
            contactInSelectionService.saveContactInSelection(contactInSelection),
            ContactInSelectionDto.class);
    return new ResponseEntity<>(result, HttpStatus.CREATED);
  }
}
