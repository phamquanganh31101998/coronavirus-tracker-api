package com.example.demo.models;

public class CountryWithProvinceModel {
    private int id;
    private String name;
    private int provinceId;
    private String provinceName;

    public CountryWithProvinceModel() {

    }

    public CountryWithProvinceModel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public CountryWithProvinceModel(int id, String name, int provinceId, String provinceName) {
        this.id = id;
        this.name = name;
        this.provinceId = provinceId;
        this.provinceName = provinceName;
    }

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

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }
}
