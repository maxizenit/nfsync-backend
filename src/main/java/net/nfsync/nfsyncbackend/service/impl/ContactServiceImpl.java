package net.nfsync.nfsyncbackend.service.impl;

import lombok.RequiredArgsConstructor;
import net.nfsync.nfsyncbackend.entity.Contact;
import net.nfsync.nfsyncbackend.exception.ContactNotFoundException;
import net.nfsync.nfsyncbackend.repository.ContactRepository;
import net.nfsync.nfsyncbackend.service.ContactService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

  private final ContactRepository contactRepository;

  @Override
  public Contact getContactById(Integer id) {
    return contactRepository.findById(id).orElseThrow(() -> new ContactNotFoundException(id));
  }

  @Override
  public Contact saveContact(Contact contact) {
    return contactRepository.save(contact);
  }
}
