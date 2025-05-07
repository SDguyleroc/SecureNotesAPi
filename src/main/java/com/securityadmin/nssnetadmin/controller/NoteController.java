package com.securityadmin.nssnetadmin.controller;

import com.securityadmin.nssnetadmin.model.Note;
import com.securityadmin.nssnetadmin.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    /**
     * Handles HTTP POST requests to create a new note for an authenticated user.
     *
     * @param content the content of the note to be created
     * @param userDetails the authentication details of the user creating the note
     * @return the newly created note as a successful HTTP response
     *
     * AuthenticationPrincipal comes from Spring Security used to inject the current authenticated user details in the controller
     */
    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody String content,
                                           @AuthenticationPrincipal UserDetails userDetails) {
        String username = userDetails.getUsername();
        System.out.println("USER DETAILS: " + username);
        return ResponseEntity.ok(noteService.createNoteForUser(username, content));
    }

    /**
     * Retrieves the list of notes for an authenticated user.
     *
     * @param userDetails the authentication details of the user retrieving the note list
     * @return a successful HTTP response containing the list of notes
     *
     * AuthenticationPrincipal comes from Spring Security used to inject the current authenticated user details in the controller
     */
    @GetMapping
    public ResponseEntity<List<Note>>  getNoteList(@AuthenticationPrincipal UserDetails userDetails) {
        String username = userDetails.getUsername();
        System.out.println("USER DETAILS: " + username);

        return ResponseEntity.ok(noteService.getNotesForUser(username));
    }

    /**
     * Updates a note for an authenticated user.
     *
     * @param noteId the ID of the note to be updated
     * @param content the new content of the note
     * @param userDetails the authentication details of the user updating the note
     * @return a successful HTTP response containing the updated note
     *
     * AuthenticationPrincipal comes from Spring Security used to inject the current authenticated user details in the controller
     */
    @PutMapping("/{noteId}")
    public ResponseEntity<Note> updateNote(@PathVariable Long noteId,
                                           @RequestBody String content,
                                           @AuthenticationPrincipal UserDetails userDetails)
    {
        String username = userDetails.getUsername();
        System.out.println("USER DETAILS: " + username);
        return ResponseEntity.ok(noteService.updateNoteForUser(noteId, content, username));

    }

    /**
     * Handles HTTP DELETE requests to delete a note for an authenticated user.
     *
     * @param noteId the id of the note to be deleted
     * @param userDetails the authentication details of the user deleting the note
     * @return a successful HTTP response indicating that the note was deleted
     *
     * AuthenticationPrincipal comes from Spring Security used to inject the current authenticated user details in the controller
     */

    @DeleteMapping("/{noteId}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long noteId, @AuthenticationPrincipal UserDetails userDetails) {

        String username = userDetails.getUsername();

        System.out.println("USER DETAILS: " + username);

        noteService.deleteNoteForUser(noteId, username);
        return ResponseEntity.ok().build();
    }


}
