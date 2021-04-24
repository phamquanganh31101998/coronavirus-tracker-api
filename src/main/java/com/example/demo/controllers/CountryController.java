package com.example.demo.controllers;

import com.example.demo.models.CountryProvince;
import com.example.demo.models.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Country;
import com.example.demo.repositories.CountryRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class CountryController {
	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;
	
//	@GetMapping("/countries")
//	public @ResponseBody Iterable<Country> getAllCountries() {
//		return countryRepository.findAll();
//	}

//	@GetMapping("/country")
//	public List<Country> getAllCountry () {
//		String sql = "SELECT * FROM country";
//		return jdbcTemplate.query(sql, new HashMap<>(), new BeanPropertyRowMapper<Country>(Country.class));
//	}

//	@GetMapping("country/province")
//	public List<CountryProvince> getAllCountryWithProvince() {
//		List<CountryProvince> listCountryWithProvince = new ArrayList<CountryProvince>();
//		String sql = "SELECT c.id id, c.name name, p.id province_id, p.name province_name FROM country as c LEFT JOIN province as p ON p.country = c.id";
//		jdbcTemplate.query(sql, (RowMapper<Void>) (rs, rowNum) -> {
//			int id = rs.getInt("id");
//			String name = rs.getString("name");
//			List<Province> listProvince = new ArrayList<>();
//
//			// add one province to the list
//			if (rs.getInt("province_id") != 0) {
//				Province province = new Province(rs.getInt("province_id"), rs.getString("province_name"));
//				listProvince.add(province);
//			}
//			CountryProvince country = new CountryProvince(id, name, listProvince);
//			listCountryWithProvince.add(country);
//			return null;
//		});
//		List<CountryProvince> result = new ArrayList<>();
//		for (int i = 0; i < listCountryWithProvince.size(); i++) {
//			CountryProvince current_row = listCountryWithProvince.get(i);
//			// add the first element
//			if (result.size() == 0) {
//				result.add(current_row);
//			}
//			else {
//				CountryProvince last_result = result.get(result.size() - 1);
//				if (last_result.getId() != current_row.getId()) {
//					result.add(current_row);
//				}
//				else {
//					List<Province> last_result_province_list = last_result.getProvinceList();
//					Province current_row_province = current_row.getProvinceList().get(0);
//					last_result_province_list.add(current_row_province);
//					last_result.setProvinceList(last_result_province_list);
//				}
//			}
//		}
//		return result;
//	}
}
