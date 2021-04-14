package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Country;

public interface CountryRepository extends CrudRepository<Country, Integer>{

}
