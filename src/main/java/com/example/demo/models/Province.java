package com.example.demo.models;

import javax.persistence.*;

@Entity
public class Province {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;

    @ManyToOne
    @JoinColumn(name="country")
    private Country country;

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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Province(Integer id) {
        this.id = id;
    }

    public Province(Integer id, String name, Country country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }
}
