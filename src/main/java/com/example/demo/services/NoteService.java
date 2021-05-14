package com.example.demo.services;

import com.example.demo.entities.Note;
import com.example.demo.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {
    @Autowired
    NoteRepository noteRepository;

    public Note createNote(Integer created_by, String content) {
        Note note;
        if (created_by == null) {
            note = new Note(content);
        }
        else {
            note = new Note(created_by, content);
        }
        return noteRepository.save(note);
    }

    public Note getNoteById(int id){
        return noteRepository.findById(id).orElse(null);
    }

    public List<Note> getAllNotes(){
        return (List<Note>) noteRepository.findAll();
    }

    public void deleteNote(int id) {
        if (noteRepository.existsById(id)) {
            noteRepository.deleteById(id);
        }
    }

    public void updateNote(int id, String content){
        Note note = getNoteById(id);
        if (note != null) {
            note.setContent(content);
            noteRepository.save(note);
        }
    }
}
