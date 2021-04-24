package com.example.demo.models;

import com.example.demo.entities.Province;

import javax.persistence.*;

public class ProvinceModel {
    private Integer id;
    private String name;
    private String country;

    public ProvinceModel (Province provinceEntity, String countryName) {
        this.id = provinceEntity.getId();
        this.name = provinceEntity.getName();
        this.country = countryName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

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

}
