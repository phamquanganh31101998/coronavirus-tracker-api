package com.example.demo.dtos;

import com.example.demo.models.ProvinceModel;

public class ProvinceDto {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProvinceDto(ProvinceModel model) {
        this.id = model.getId();
        this.name = model.getName();
    }
}
