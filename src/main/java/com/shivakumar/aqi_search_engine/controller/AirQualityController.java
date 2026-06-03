package com.shivakumar.aqi_search_engine.controller;

import com.shivakumar.aqi_search_engine.dto.AQIResponseDTO;
import com.shivakumar.aqi_search_engine.service.IAirQualityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/air-quality")
public class AirQualityController {

    private final IAirQualityService airQualityService;

    public AirQualityController(
            IAirQualityService airQualityService
    ) {
        this.airQualityService = airQualityService;
    }

    @GetMapping("/city")
    public ResponseEntity<AQIResponseDTO> getAQI(
            @RequestParam String city
    ) {

        return ResponseEntity.ok(
                airQualityService.getAQIByCity(city)
        );
    }
}