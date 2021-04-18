package com.example.demo.models;

import java.util.List;

public class CountryProvince {
    private int id;
    private String name;
    private List<Province> provinceList;

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

    public List<Province> getProvinceList() {
        return provinceList;
    }

    public void setProvinceList(List<Province> provinceList) {
        this.provinceList = provinceList;
    }

    public CountryProvince(int id) {
        this.id = id;
    }

    public CountryProvince(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public CountryProvince(int id, String name, List<Province> provinceList) {
        this.id = id;
        this.name = name;
        this.provinceList = provinceList;
    }
}
