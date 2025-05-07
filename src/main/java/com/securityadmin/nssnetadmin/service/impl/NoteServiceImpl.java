package com.securityadmin.nssnetadmin.service.impl;

import com.securityadmin.nssnetadmin.model.Note;
import com.securityadmin.nssnetadmin.repo.NoteRepository;
import com.securityadmin.nssnetadmin.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public Note createNoteForUser(String username, String content) {

        Note note = new Note();
        note.setContent(content);
        note.setOwnerUsername(username);
        return noteRepository.save(note);
    }


    @Override
    public Note updateNoteForUser(long noteId, String content, String username) {
        Note note = noteRepository.findById(noteId).orElseThrow(() -> new RuntimeException("Note not found"));
        note.setContent(content);

        return noteRepository.save(note);
    }

    @Override
    public void deleteNoteForUser(long noteId, String username) {
       noteRepository.deleteById(noteId);

    }



    @Transactional
    @Override
    public List<Note> getNotesForUser(String username) {
        return noteRepository.findByOwnerUsername(username);
    }

}
