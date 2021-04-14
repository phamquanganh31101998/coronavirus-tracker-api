package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Country;
import com.example.demo.repositories.CountryRepository;

@RestController
public class CountryController {
	@Autowired
	private CountryRepository countryRepository;
	
	@GetMapping("/countries")
	public @ResponseBody Iterable<Country> getAllCountries() {
		return countryRepository.findAll();
	}
}
