package com.syboks.vehiclesearch.service.impl;

import com.syboks.vehiclesearch.dao.ManufacturerDAO;
import com.syboks.vehiclesearch.entity.Manufacturer;
import com.syboks.vehiclesearch.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerImpl implements ManufacturerService {

    @Autowired
    private ManufacturerDAO manufacturerDAO;
    @Override
    public Manufacturer saveManufacturer(Manufacturer manufacturer) {
        return manufacturerDAO.save(manufacturer);
    }

    @Override
    public List<Manufacturer> fetchAllManufacturers() {
        List<Manufacturer> allManufacturers=manufacturerDAO.findAll();
        return allManufacturers;
    }
}
