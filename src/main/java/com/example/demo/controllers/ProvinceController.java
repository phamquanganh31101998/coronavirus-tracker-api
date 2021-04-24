package com.example.demo.controllers;

import com.example.demo.models.ProvinceModel;
import com.example.demo.services.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
public class ProvinceController {
    @Autowired
    ProvinceService provinceService;

    @GetMapping("/province")
    public List<ProvinceModel> getAll() {
        return provinceService.getAll();
    }

    @GetMapping("/province/{name}")
    @ResponseBody
    public ProvinceModel getProvinceByName(@PathVariable String name) throws SQLException {
        return provinceService.getProvinceByName(name);
    }

}
