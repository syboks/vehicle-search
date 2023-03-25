package com.syboks.vehiclesearch.service.impl;

import com.syboks.vehiclesearch.dao.ManufacturerDAO;
import com.syboks.vehiclesearch.entity.Manufacturer;
import com.syboks.vehiclesearch.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    @Override
    public Manufacturer getManufacturerForId(int id) {
        Optional<Manufacturer> dbManufacturer=manufacturerDAO.findById(id);
        if (dbManufacturer.isPresent()) {
            return dbManufacturer.get();
        }
        return null;
    }


    @Override
    public Manufacturer updateManufacturer(int id, Manufacturer updatedManufacturer) {
        Manufacturer dbManufacturer=getManufacturerForId(id);
        if(dbManufacturer!=null && Objects.nonNull(updatedManufacturer)){
            if( !"".equalsIgnoreCase(updatedManufacturer.getManufacturerName())){
                dbManufacturer.setManufacturerName(updatedManufacturer.getManufacturerName());
            }
            if( !"".equalsIgnoreCase(updatedManufacturer.getCountryOfOrigin())){
                dbManufacturer.setCountryOfOrigin(updatedManufacturer.getCountryOfOrigin());
            }
            manufacturerDAO.save(dbManufacturer);
        }
        return dbManufacturer;
    }
}
