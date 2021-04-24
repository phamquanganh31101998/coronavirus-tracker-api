package com.example.demo.models;

import com.example.demo.entities.Country;

import javax.persistence.*;

public class CountryModel {
	private Integer id;
	private String name;

	public CountryModel(Country countryEntity) {
		this.id = countryEntity.getId();
		this.name = countryEntity.getName();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
