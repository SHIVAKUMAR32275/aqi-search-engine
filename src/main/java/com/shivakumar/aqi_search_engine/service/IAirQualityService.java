package com.shivakumar.aqi_search_engine.service;

import com.shivakumar.aqi_search_engine.dto.AQIResponseDTO;

public interface IAirQualityService {

    AQIResponseDTO getAQIByCity(String city);
}