package com.example.demo.repositories;

import com.example.demo.dtos.CountryDto;
import com.example.demo.models.CountryWithProvinceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CountryRepository{
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<CountryWithProvinceModel> getAll() {
        String sql = "SELECT c.id id, c.name name, p.id provinceId, p.name provinceName FROM country as c LEFT JOIN province as p ON p.country = c.id";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int provinceId = rs.getInt("provinceId");
            String provinceName = rs.getString("provinceName");
            if (provinceId == 0) {
                return new CountryWithProvinceModel(id, name);
            }
            else {
                return new CountryWithProvinceModel(id, name, provinceId, provinceName);
            }
        });
    }
}
