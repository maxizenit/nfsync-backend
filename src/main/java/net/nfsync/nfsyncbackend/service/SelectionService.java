package net.nfsync.nfsyncbackend.service;

import net.nfsync.nfsyncbackend.entity.Selection;

public interface SelectionService {

  Selection getSelectionById(Integer id);

  Selection saveSelection(Selection selection);
}
