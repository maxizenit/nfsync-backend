package net.nfsync.nfsyncbackend.service;

import java.util.List;
import net.nfsync.nfsyncbackend.entity.SocialLink;
import net.nfsync.nfsyncbackend.entity.User;

public interface SocialLinkService {

  SocialLink saveSocialLinks(SocialLink socialLink);
}
