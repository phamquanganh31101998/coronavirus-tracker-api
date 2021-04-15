package com.example.demo.models;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Country {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;

	@OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
	private Collection<Province> provinces;

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
