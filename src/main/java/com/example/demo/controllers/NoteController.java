package com.example.demo.controllers;

import com.example.demo.entities.Note;
import com.example.demo.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class NoteController {
    @Autowired
    NoteService noteService;

    @PostMapping("/note")
    public Note createNote(@RequestBody Map<String, String> body) {
        if (body.get("created_by") != null) {
            return noteService.createNote(Integer.parseInt(body.get("created_by")), body.get("content"));
        }
        else {
            return noteService.createNote(null, body.get("content"));
        }
    }

    @GetMapping("/note")
    public List<Note> getAllNotes() {
        return noteService.getAllNotes();
    }

    @GetMapping("/note/{id}")
    public Note getNoteById(@PathVariable int id) {
        return noteService.getNoteById(id);
    }

    @PutMapping("/note/{id}")
    public void updateNoteById(@PathVariable int id, @RequestBody Map<String, String> body) {
        noteService.updateNote(id, body.get("content"));
    }
    @DeleteMapping("/note/{id}")
    public void deleteNoteByID(@PathVariable int id) {
        noteService.deleteNote(id);
    }
}
