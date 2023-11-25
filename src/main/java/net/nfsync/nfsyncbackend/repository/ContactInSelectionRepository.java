package net.nfsync.nfsyncbackend.repository;

import java.util.List;
import net.nfsync.nfsyncbackend.entity.ContactInSelection;
import net.nfsync.nfsyncbackend.entity.Selection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactInSelectionRepository extends JpaRepository<ContactInSelection, Integer> {

    List<ContactInSelection> findAllBySelection(Selection selection);
}
