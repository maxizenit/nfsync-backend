package net.nfsync.nfsyncbackend.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import net.nfsync.nfsyncbackend.dto.CreateInterestDto;
import net.nfsync.nfsyncbackend.dto.InterestDto;
import net.nfsync.nfsyncbackend.entity.Interest;
import net.nfsync.nfsyncbackend.service.InterestService;
import net.nfsync.nfsyncbackend.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/interests")
@RequiredArgsConstructor
public class InterestController {

  private final InterestService interestService;

  private final UserService userService;

  private final ModelMapper modelMapper;

  @Operation(summary = "Создание интереса для пользователя")
  @PostMapping
  public ResponseEntity<InterestDto> createInterestForUser(
      @RequestBody CreateInterestDto createInterestDto) {
    Interest interest = new Interest();
    interest.setUser(userService.getUserById(createInterestDto.getUserId()));
    interest.setTitle(createInterestDto.getTitle());

    InterestDto result = modelMapper.map(interestService.saveInterest(interest), InterestDto.class);
    return new ResponseEntity<>(result, HttpStatus.CREATED);
  }
}
