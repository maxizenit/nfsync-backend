package net.nfsync.nfsyncbackend.service;

import net.nfsync.nfsyncbackend.entity.Contact;

public interface ContactService {

  Contact getContactById(Integer id);

  Contact saveContact(Contact contact);
}
