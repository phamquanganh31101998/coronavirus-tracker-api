package com.example.demo.controllers;

import com.example.demo.contracts.ResponseContract;
import com.example.demo.services.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProvinceController {
    @Autowired
    ProvinceService provinceService;

    @GetMapping("/province")
    @ResponseBody
    public ResponseContract<?> getProvince(@RequestParam(name = "name", required = false) String name,
                                           @RequestParam(name = "countryName", required = false) String countryName) {
        if (name == null && countryName == null) {
            return provinceService.getAll();
        }
        return provinceService.getProvinceByConditions(name, countryName);
    }

    @GetMapping("/province/{idString}")
    @ResponseBody
    public ResponseContract<?> getProvinceById(@PathVariable String idString) {
        try {
            int id = Integer.parseInt(idString);
            return provinceService.getProvinceById(id);
        } catch (Exception e) {
            return new ResponseContract<>("failed", HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), null);
        }
    }
}
