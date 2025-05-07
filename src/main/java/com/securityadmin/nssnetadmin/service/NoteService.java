package com.securityadmin.nssnetadmin.service;

import com.securityadmin.nssnetadmin.model.Note;
import com.securityadmin.nssnetadmin.repo.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface NoteService{

     Note createNoteForUser(String username, String content);

     Note updateNoteForUser(long noteId, String content, String username);


    void deleteNoteForUser(long noteId, String username);

    List<Note> getNotesForUser(String username);
}
