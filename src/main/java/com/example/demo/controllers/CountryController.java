package com.example.demo.controllers;

import com.example.demo.dtos.CountryDto;
import com.example.demo.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repositories.CountryRepository;

import java.util.List;

@RestController
public class CountryController {
	@Autowired
	CountryService countryService;

	@GetMapping("/country")
	public List<CountryDto> getAllCountry () {
		return countryService.getAll();
	}
}
