package com.example.demo.entities;

import javax.persistence.*;

@Entity
@Table(name = "note")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(nullable = true, name = "created_by")
    private int created_by;

    @Column(nullable = false, name = "content")
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCreated_by() {
        return created_by;
    }

    public void setCreated_by(int created_by) {
        this.created_by = created_by;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Note() {
    }

    // for create method
    public Note(int created_by, String content) {
        this.created_by = created_by;
        this.content = content;
    }

    // for create with no created_by
    public Note(String content) {
        this.content = content;
    }

    // for update method

    public Note(int id, int created_by, String content) {
        this.id = id;
        this.created_by = created_by;
        this.content = content;
    }
}
