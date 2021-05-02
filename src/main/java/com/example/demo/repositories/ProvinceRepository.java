package com.example.demo.repositories;

import com.example.demo.entities.Province;
import com.example.demo.models.ProvinceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProvinceRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<ProvinceModel> getProvinceByConditions(String name, String countryName) {
        try {
            String sql = "SELECT p.id id, p.name name, c.name countryName, c.id countryId FROM province as p, country as c WHERE c.id = p.country";
            Map<String, Object> maps = new HashMap<>();
            if (name != null) {
                sql = sql + " AND p.name LIKE CONCAT('%', :name, '%')";
                maps.put("name", name);
            }
            if (countryName != null) {
                sql = sql + " AND c.name LIKE CONCAT('%', :countryName, '%')";
                maps.put("countryName", countryName);
            }
            return namedParameterJdbcTemplate.query(sql, maps, (rs, rowNum) -> {
                Province province = new Province(rs.getInt("id"), rs.getString("name"), rs.getInt("countryId"));
                return new ProvinceModel(province, rs.getString("countryName"));
            });
        }
        catch (Exception e) {
            return null;
        }
    }

    public List<ProvinceModel> getAll() {
        String sql = "SELECT province.id id, province.name name, country.id cid, country.name cname FROM province JOIN country WHERE country.id = province.country";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Province province = new Province(rs.getInt("id"), rs.getString("name"), rs.getInt("cid"));
            return new ProvinceModel(province, rs.getString("cname"));
        });
    }

    public ProvinceModel getProvinceById(int id) {
        try {
            String sql = "SELECT p.id id, p.name name, c.name countryName, c.id countryId FROM province as p, country as c WHERE c.id = p.country AND p.id = :id";
            Map<String, Object> maps = new HashMap<>();
            maps.put("id", id);
            return namedParameterJdbcTemplate.queryForObject(sql, maps, (rs, rowNum) -> {
                Province province = new Province(rs.getInt("id"), rs.getString("name"), rs.getInt("countryId"));
                return new ProvinceModel(province, rs.getString("countryName"));
            });
        }
        catch (Exception e) {
            return null;
        }
    }
}
