package net.nfsync.nfsyncbackend.repository;

import java.util.List;
import net.nfsync.nfsyncbackend.entity.SocialLink;
import net.nfsync.nfsyncbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialLinkRepository extends JpaRepository<SocialLink, Integer> {

  List<SocialLink> findAllByUser(User user);
}
