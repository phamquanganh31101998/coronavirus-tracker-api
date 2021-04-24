package com.example.demo.dtos;

import com.example.demo.models.CountryModel;

import java.util.List;

public class CountryDto {
    private int id;
    private String name;
    private List<ProvinceDto> listProvince;

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

    public List<ProvinceDto> getListProvince() {
        return listProvince;
    }

    public void setListProvince(List<ProvinceDto> listProvince) {
        this.listProvince = listProvince;
    }

    public CountryDto(CountryModel model, List<ProvinceDto> listProvinceDto) {
        this.id = model.getId();
        this.name = model.getName();
        this.listProvince = listProvinceDto;
    }
}
