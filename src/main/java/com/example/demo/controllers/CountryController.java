package com.example.demo.controllers;

import com.example.demo.models.CountryProvince;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Country;
import com.example.demo.repositories.CountryRepository;

import java.util.HashMap;
import java.util.List;

@RestController
public class CountryController {
	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;
	
	@GetMapping("/countries")
	public @ResponseBody Iterable<Country> getAllCountries() {
		return countryRepository.findAll();
	}

	@GetMapping("/country")
	public List<Country> getAllCountry () {
		String sql = "SELECT * FROM country";
		return jdbcTemplate.query(sql, new HashMap<>(), new BeanPropertyRowMapper<Country>(Country.class));
	}

	@GetMapping("country/province")
	public List<CountryProvince> getAllCountryWithProvince() {
		String sql = "SELECT c.id id, c.name name, p.name FROM country as c LEFT JOIN province as p ON p.country = c.id";
		return jdbcTemplate.query(sql, new HashMap<>(), new BeanPropertyRowMapper<CountryProvince>(CountryProvince.class));
	}
}
