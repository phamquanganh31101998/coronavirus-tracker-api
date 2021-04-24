package com.example.demo.repositories;

import com.example.demo.entities.Province;
import com.example.demo.models.ProvinceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProvinceRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public ProvinceModel getProvinceByName (String name) {
        String sql = "SELECT * FROM province WHERE name = :name";
        Map<String, Object> maps = new HashMap<String, Object>();
        maps.put("name", name);
        Province province = namedParameterJdbcTemplate.queryForObject(sql, maps, new BeanPropertyRowMapper<Province>(Province.class));
        assert province != null;
        return new ProvinceModel(province, name);
    }

    public List<ProvinceModel> getAll() {
        String sql = "SELECT province.id id, province.name name, country.id cid, country.name cname FROM province JOIN country WHERE country.id = province.country";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Province province = new Province(rs.getInt("id"), rs.getString("name"), rs.getInt("cid"));
            return new ProvinceModel(province, rs.getString("cname"));
        });
    }
}
