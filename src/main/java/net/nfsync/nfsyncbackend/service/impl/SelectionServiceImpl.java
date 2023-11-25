package net.nfsync.nfsyncbackend.service.impl;

import lombok.RequiredArgsConstructor;
import net.nfsync.nfsyncbackend.entity.Selection;
import net.nfsync.nfsyncbackend.exception.SelectionNotFoundException;
import net.nfsync.nfsyncbackend.repository.SelectionRepository;
import net.nfsync.nfsyncbackend.service.SelectionService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SelectionServiceImpl implements SelectionService {

  private final SelectionRepository selectionRepository;

  @Override
  public Selection getSelectionById(Integer id) {
    return selectionRepository.findById(id).orElseThrow(() -> new SelectionNotFoundException(id));
  }

  @Override
  public Selection saveSelection(Selection selection) {
    return selectionRepository.save(selection);
  }
}
