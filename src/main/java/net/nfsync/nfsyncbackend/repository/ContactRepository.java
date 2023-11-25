package net.nfsync.nfsyncbackend.repository;

import java.util.List;
import net.nfsync.nfsyncbackend.entity.Contact;
import net.nfsync.nfsyncbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

  List<Contact> findAllBySubscriber(User user);
}
