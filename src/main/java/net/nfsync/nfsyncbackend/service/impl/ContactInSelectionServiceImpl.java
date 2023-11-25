package net.nfsync.nfsyncbackend.service.impl;

import lombok.RequiredArgsConstructor;
import net.nfsync.nfsyncbackend.entity.ContactInSelection;
import net.nfsync.nfsyncbackend.repository.ContactInSelectionRepository;
import net.nfsync.nfsyncbackend.service.ContactInSelectionService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactInSelectionServiceImpl implements ContactInSelectionService {

  private final ContactInSelectionRepository contactInSelectionRepository;

  @Override
  public ContactInSelection saveContactInSelection(ContactInSelection contactInSelection) {
    return contactInSelectionRepository.save(contactInSelection);
  }
}
