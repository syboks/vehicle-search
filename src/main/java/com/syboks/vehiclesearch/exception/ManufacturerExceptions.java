package com.syboks.vehiclesearch.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ManufacturerExceptions {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ManufactureNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleManufacturerNotFound(ManufactureNotFoundException ex){
        ErrorResponse response=new ErrorResponse(HttpStatus.NOT_FOUND,ex.getMessage());
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MisssingFieldException.class)
    public ResponseEntity<ErrorResponse> handleMissingFieldsError(MisssingFieldException ex){
        ErrorResponse err=new ErrorResponse(HttpStatus.BAD_REQUEST,ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }
}
