package com.example.demo.services;

import com.example.demo.contracts.ResponseContract;
import com.example.demo.models.ProvinceModel;
import com.example.demo.repositories.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ProvinceService {
    @Autowired
    ProvinceRepository provinceRepository;

    public ResponseContract<?> getProvinceByName(String name) {
        try {
            List<ProvinceModel> body = provinceRepository.getProvinceByName(name);
            if (body.size() == 0) {
                return new ResponseContract<>("failed", HttpStatus.NOT_FOUND.value(), "Cannot find any province", null);
            }
            return new ResponseContract<>("success", HttpStatus.OK.value(), "success", body);
        }
        catch (Exception e) {
            return new ResponseContract<>("failed", HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), null);
        }
    }

    public ResponseContract<?> getProvinceById(int id) {
        try {
            ProvinceModel body = provinceRepository.getProvinceById(id);
            if (body == null) {
                return new ResponseContract<>("failed", HttpStatus.NOT_FOUND.value(), "Cannot find any province", null);
            }
            return new ResponseContract<>("success", HttpStatus.OK.value(), "success", body);
        }
        catch (Exception e) {
            return new ResponseContract<>("failed", HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), null);
        }
    }

    public ResponseContract<?> getAll() {
        try {
            List<ProvinceModel> body = provinceRepository.getAll();
            if (body.size() == 0) {
                return new ResponseContract<>("failed", HttpStatus.NOT_FOUND.value(), "Cannot find any province", null);
            }
            return new ResponseContract<>("success", HttpStatus.OK.value(), "success", body);
        }
        catch (Exception e) {
            return new ResponseContract<>("failed", HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), null);
        }
    }
}
