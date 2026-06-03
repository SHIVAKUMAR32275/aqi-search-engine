package com.shivakumar.aqi_search_engine.exceptions;

public class CityNotFoundException extends RuntimeException {

    public CityNotFoundException(String message) {
        super(message);
    }
}