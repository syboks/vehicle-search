package com.syboks.vehiclesearch.service;

import com.syboks.vehiclesearch.entity.Manufacturer;
import com.syboks.vehiclesearch.exception.ManufactureNotFoundException;

import java.util.List;

public interface ManufacturerService {
    Manufacturer saveManufacturer(Manufacturer manufacturer);
    List<Manufacturer> fetchAllManufacturers();
    Manufacturer getManufacturerForId(int id);
    Manufacturer updateManufacturer(int id,Manufacturer updatedManufacturer);
    void deleteManufacturerById(int id) throws ManufactureNotFoundException;
}
