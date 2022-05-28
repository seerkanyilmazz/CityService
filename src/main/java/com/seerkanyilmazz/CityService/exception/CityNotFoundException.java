package com.seerkanyilmazz.CityService.exception;

public class CityNotFoundException extends RuntimeException {
    public CityNotFoundException(String message){
        super(message);
    }
}
