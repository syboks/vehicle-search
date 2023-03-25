package com.syboks.vehiclesearch.controller;

import com.sun.javaws.exceptions.MissingFieldException;
import com.syboks.vehiclesearch.entity.Manufacturer;
import com.syboks.vehiclesearch.exception.ManufactureNotFoundException;
import com.syboks.vehiclesearch.exception.MisssingFieldException;
import com.syboks.vehiclesearch.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/manufacturers")
public class ManufacturerController {

    @Autowired
    private ManufacturerService manufacturerService;

    @PostMapping
    public ResponseEntity<Manufacturer> createManufacturerInDb(@RequestBody Manufacturer manufacturer){
        Manufacturer dbRecord=manufacturerService.saveManufacturer(manufacturer);
        return new ResponseEntity<>(dbRecord, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Manufacturer>> getAllManufacturers(){
        List<Manufacturer> savedmanufacturers=manufacturerService.fetchAllManufacturers();
        return ResponseEntity.status(HttpStatus.OK).body(savedmanufacturers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Manufacturer> getManufacturerById(@PathVariable int id) throws ManufactureNotFoundException {
        Manufacturer dbManufacturer=manufacturerService.getManufacturerForId(id);
        if(dbManufacturer==null){
            throw new ManufactureNotFoundException("No manufacturer found for ID-"+id);
        }
        return ResponseEntity.ok(dbManufacturer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Manufacturer> updateMaufacturer(@PathVariable int id, @Valid @RequestBody Manufacturer manufacturer, BindingResult result) throws Exception {
        if(result.hasErrors()){
            List<ObjectError> errors=result.getAllErrors();
            throw new MisssingFieldException(errors.get(0).getDefaultMessage());
            //System.out.println("******Validation Error************"+result.getAllErrors());
        }
        Manufacturer updatedManufacturer=manufacturerService.updateManufacturer(id,manufacturer);
        if(updatedManufacturer==null){
            throw new ManufactureNotFoundException("No manufacturer found for ID-"+id);
        }
        return new ResponseEntity<>(updatedManufacturer, HttpStatus.OK);
    }


}
