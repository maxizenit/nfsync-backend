package net.nfsync.nfsyncbackend.repository;

import net.nfsync.nfsyncbackend.entity.Interest;
import net.nfsync.nfsyncbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InterestRepository extends JpaRepository<Interest, Integer> {

    List<Interest> findAllByUser(User user);
}
