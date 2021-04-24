package com.example.demo.services;

import com.example.demo.models.ProvinceModel;
import com.example.demo.repositories.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ProvinceService {
    @Autowired
    ProvinceRepository provinceRepository;

    public ProvinceModel getProvinceByName(String name) throws SQLException {
        return provinceRepository.getProvinceByName(name);
    }

    public List<ProvinceModel> getAll() {
        return provinceRepository.getAll();
    }
}
