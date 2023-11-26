package net.nfsync.nfsyncbackend.repository;

import net.nfsync.nfsyncbackend.entity.Avatar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AvatarRepository extends JpaRepository<Avatar, Integer> {

    Optional<Avatar> findById(Integer id);
}
