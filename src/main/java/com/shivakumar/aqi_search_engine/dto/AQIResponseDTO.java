package com.shivakumar.aqi_search_engine.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AQIResponseDTO {

    private String city;

    private Integer aqi;

    private String dominantPollutant;

    private Double temperature;

    private Double humidity;

    private String status;

    private String lastUpdated;
}