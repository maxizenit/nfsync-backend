package net.nfsync.nfsyncbackend.repository;

import java.util.List;
import net.nfsync.nfsyncbackend.entity.Selection;
import net.nfsync.nfsyncbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SelectionRepository extends JpaRepository<Selection, Integer> {

  List<Selection> findAllByUser(User user);
}
