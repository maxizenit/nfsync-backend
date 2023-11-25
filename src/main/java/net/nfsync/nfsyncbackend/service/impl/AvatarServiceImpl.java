package net.nfsync.nfsyncbackend.service.impl;

import lombok.RequiredArgsConstructor;
import net.nfsync.nfsyncbackend.entity.Avatar;
import net.nfsync.nfsyncbackend.repository.AvatarRepository;
import net.nfsync.nfsyncbackend.service.AvatarService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AvatarServiceImpl implements AvatarService {

  private final AvatarRepository avatarRepository;

  @Override
  public Avatar saveAvatar(Avatar avatar) {
    return avatarRepository.save(avatar);
  }

}
