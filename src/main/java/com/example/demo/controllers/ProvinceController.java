package com.example.demo.controllers;

import com.example.demo.models.ProvinceModel;
import com.example.demo.services.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class ProvinceController {
    @Autowired
    ProvinceService provinceService;

    @GetMapping("/provinces")
    public List<ProvinceModel> getAll() {
        return provinceService.getAll();
    }

    @GetMapping("/province")
    @ResponseBody
    public List<ProvinceModel> getProvinceByName(@RequestParam(name = "name") String name) throws SQLException {
        return provinceService.getProvinceByName(name);
    }

    @GetMapping("/province/{id}")
    @ResponseBody
    public ProvinceModel getProvinceById(@PathVariable int id) throws SQLException {
        return provinceService.getProvinceById(id);
    }
}
