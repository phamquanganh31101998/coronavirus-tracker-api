package com.example.demo.controllers;

import com.example.demo.models.Province;
import com.example.demo.repositories.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class ProvinceController {
    @Autowired
    private ProvinceRepository provinceRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;
    @GetMapping("/province")
    public @ResponseBody
    List<Object> getAllProvince() {
        List<Object> listProvince = new ArrayList<>();
        String sql = "SELECT province.id pid, province.name pname, country.name cname FROM province JOIN country LEFT JOIN country ON province.country = country.id";
        jdbcTemplate.query(sql,
                (rs, rowNum) -> new Object(rs.getInt("pid"), rs.getString("pname"), rs.getString("cname"))
        ).forEach(province-> listProvince.push(province));
    }
}
