package com.example.demo.services;

import com.example.demo.dtos.CountryDto;
import com.example.demo.dtos.ProvinceDto;
import com.example.demo.entities.Country;
import com.example.demo.entities.Province;
import com.example.demo.models.CountryModel;
import com.example.demo.models.CountryWithProvinceModel;
import com.example.demo.models.ProvinceModel;
import com.example.demo.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService {
    @Autowired
    CountryRepository countryRepository;

    public List<CountryDto> getAll() {
        List<CountryDto> countryDtos = new ArrayList<>();
        List<CountryWithProvinceModel> countryWithProvinceModels = countryRepository.getAll();
        for (CountryWithProvinceModel model : countryWithProvinceModels) {
            int id = model.getId();
            String name = model.getName();
            int provinceId = model.getProvinceId();
            // for null checking
            Integer provinceIdObj = provinceId;
            String provinceName = model.getProvinceName();
            CountryModel countryModel = new CountryModel(new Country(id, name));

            // if list is null, add to the list immediately
            if (countryDtos.size() == 0) {
                List<ProvinceDto> provinceDtoList = new ArrayList<>();
                if (provinceIdObj != 0) {
                    ProvinceDto provinceDto = new ProvinceDto(new ProvinceModel(new Province(provinceId, provinceName, id), name));
                    provinceDtoList.add(provinceDto);
                }
                CountryDto countryDto = new CountryDto(countryModel, provinceDtoList);
                countryDtos.add(countryDto);
            }
            else {
                CountryDto lastDto = countryDtos.get(countryDtos.size() - 1);
                int lastDtoId = lastDto.getId();
                if (lastDtoId == id) {
                    List<ProvinceDto> lastDtoListProvince= lastDto.getListProvince();
                    ProvinceModel provinceModel = new ProvinceModel(new Province(provinceId, provinceName, id), name);
                    ProvinceDto provinceDto = new ProvinceDto(provinceModel);
                    lastDtoListProvince.add(provinceDto);
                    lastDto.setListProvince(lastDtoListProvince);
                }
                else {
                    List<ProvinceDto> provinceDtoList = new ArrayList<>();
                    if (provinceIdObj != 0) {
                        ProvinceDto provinceDto = new ProvinceDto(new ProvinceModel(new Province(provinceId, provinceName, id), name));
                        provinceDtoList.add(provinceDto);
                    }
                    CountryDto countryDto = new CountryDto(countryModel, provinceDtoList);
                    countryDtos.add(countryDto);
                }
            }
        }
        return countryDtos;
    }
}
