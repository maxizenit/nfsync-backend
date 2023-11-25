package net.nfsync.nfsyncbackend.service.impl;

import lombok.RequiredArgsConstructor;
import net.nfsync.nfsyncbackend.entity.SocialLink;
import net.nfsync.nfsyncbackend.repository.SocialLinkRepository;
import net.nfsync.nfsyncbackend.service.SocialLinkService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SocialLinkServiceImpl implements SocialLinkService {

  private final SocialLinkRepository socialLinkRepository;

    @Override
  public SocialLink saveSocialLinks(SocialLink socialLink) {
    return socialLinkRepository.save(socialLink);
  }
}
