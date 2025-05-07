package com.securityadmin.nssnetadmin.repo;

import com.securityadmin.nssnetadmin.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface NoteRepository extends JpaRepository<Note, Long> {

    List<Note> findByOwnerUsername(String username);
}
