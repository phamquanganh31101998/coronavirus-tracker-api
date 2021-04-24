package com.example.demo.models;

import javax.persistence.*;

@Entity
public class Province {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Province(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
