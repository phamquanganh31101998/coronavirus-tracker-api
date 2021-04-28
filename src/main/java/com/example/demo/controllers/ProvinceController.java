package com.example.demo.controllers;

import com.example.demo.contracts.ResponseContract;
import com.example.demo.models.ProvinceModel;
import com.example.demo.services.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class ProvinceController {
    @Autowired
    ProvinceService provinceService;

    @GetMapping("/province")
    @ResponseBody
    public ResponseContract<?> getProvinceByName(@RequestParam(name = "name", required = false) String name) throws SQLException {
        if (name == null) {
            return provinceService.getAll();
        }
        return provinceService.getProvinceByName(name);
    }

    @GetMapping("/province/{id}")
    @ResponseBody
    public ResponseContract<?> getProvinceById(@PathVariable int id) throws SQLException {
        try {
            return provinceService.getProvinceById(id);
        }
        catch (Exception e) {
            return new ResponseContract<>("failed", HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), null);
        }
    }
}
