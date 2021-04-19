package com.example.demo.controllers;

import com.example.demo.models.ProvinceCountry;
import com.example.demo.repositories.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class ProvinceController {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;
    @GetMapping("/province")
    public List<ProvinceCountry> getAllProvince() {
        String sql = "SELECT p.id id, p.name name, c.name countryName FROM province as p LEFT JOIN country as c ON p.country = c.id";
        return jdbcTemplate.query(sql, new HashMap<>(), new BeanPropertyRowMapper<ProvinceCountry>(ProvinceCountry.class));
    }
}
