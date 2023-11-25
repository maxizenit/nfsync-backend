package net.nfsync.nfsyncbackend.service.impl;

import lombok.RequiredArgsConstructor;
import net.nfsync.nfsyncbackend.entity.Interest;
import net.nfsync.nfsyncbackend.repository.InterestRepository;
import net.nfsync.nfsyncbackend.service.InterestService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InterestServiceImpl implements InterestService {

  private final InterestRepository interestRepository;

    @Override
  public Interest saveInterest(Interest interest) {
    return interestRepository.save(interest);
  }
}
