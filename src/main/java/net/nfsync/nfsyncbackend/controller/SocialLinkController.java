package net.nfsync.nfsyncbackend.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import net.nfsync.nfsyncbackend.dto.CreateSocialLinkDto;
import net.nfsync.nfsyncbackend.dto.SocialLinkDto;
import net.nfsync.nfsyncbackend.entity.SocialLink;
import net.nfsync.nfsyncbackend.service.SocialLinkService;
import net.nfsync.nfsyncbackend.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/social-links")
@RequiredArgsConstructor
public class SocialLinkController {

  private final SocialLinkService socialLinkService;

  private final UserService userService;

  private final ModelMapper modelMapper;

  @Operation(summary = "Создание ссылки на социальную сеть для пользователя")
  @PostMapping
  public ResponseEntity<SocialLinkDto> createSocialLinkForUser(
      @RequestBody CreateSocialLinkDto createSocialLinkDto) {
    SocialLink socialLink = new SocialLink();
    socialLink.setUser(userService.getUserById(createSocialLinkDto.getUserId()));
    socialLink.setUrl(createSocialLinkDto.getUrl());

    SocialLinkDto result =
        modelMapper.map(socialLinkService.saveSocialLinks(socialLink), SocialLinkDto.class);
    return new ResponseEntity<>(result, HttpStatus.CREATED);
  }
}
