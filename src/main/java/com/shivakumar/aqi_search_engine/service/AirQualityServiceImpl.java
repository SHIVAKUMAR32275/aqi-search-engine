package com.shivakumar.aqi_search_engine.service;

import com.shivakumar.aqi_search_engine.client.AQICNClient;
import com.shivakumar.aqi_search_engine.dto.AQIResponseDTO;
import com.shivakumar.aqi_search_engine.exceptions.CityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AirQualityServiceImpl implements IAirQualityService {

    private static final Logger logger =
            LoggerFactory.getLogger(AirQualityServiceImpl.class);

    private final AQICNClient aqicnClient;

    public AirQualityServiceImpl(AQICNClient aqicnClient) {
        this.aqicnClient = aqicnClient;
    }

    @Override
    @Cacheable(
            value = "aqi",
            key = "#city.toLowerCase()"
    )
    public AQIResponseDTO getAQIByCity(String city) {

        logger.info(
                "Fetching AQI from AQICN API for city: {}",
                city
        );

        Map<String, Object> response =
                aqicnClient.getAQIData(city);

        String apiStatus =
                response.get("status").toString();

        if (!"ok".equalsIgnoreCase(apiStatus)) {
            throw new CityNotFoundException(
                    "No AQI data found for city: " + city
            );
        }

        Map<String, Object> data =
                (Map<String, Object>) response.get("data");

        AQIResponseDTO dto = new AQIResponseDTO();

        Integer aqi =
                Integer.parseInt(
                        data.get("aqi").toString()
                );

        dto.setAqi(aqi);
        dto.setStatus(getAQIStatus(aqi));

        if (data.containsKey("dominentpol")) {
            dto.setDominantPollutant(
                    data.get("dominentpol").toString()
            );
        }

        if (data.containsKey("city")) {

            Map<String, Object> cityData =
                    (Map<String, Object>) data.get("city");

            if (cityData.containsKey("name")) {
                dto.setCity(
                        cityData.get("name").toString()
                );
            }
        }

        if (data.containsKey("time")) {

            Map<String, Object> timeData =
                    (Map<String, Object>) data.get("time");

            if (timeData.containsKey("s")) {
                dto.setLastUpdated(
                        timeData.get("s").toString()
                );
            }
        }

        if (data.containsKey("iaqi")) {

            Map<String, Object> iaqi =
                    (Map<String, Object>) data.get("iaqi");

            if (iaqi.containsKey("t")) {

                Map<String, Object> temperature =
                        (Map<String, Object>) iaqi.get("t");

                dto.setTemperature(
                        Double.parseDouble(
                                temperature.get("v").toString()
                        )
                );
            }

            if (iaqi.containsKey("h")) {

                Map<String, Object> humidity =
                        (Map<String, Object>) iaqi.get("h");

                dto.setHumidity(
                        Double.parseDouble(
                                humidity.get("v").toString()
                        )
                );
            }
        }

        return dto;
    }

    private String getAQIStatus(int aqi) {

        if (aqi <= 50)
            return "Good";

        if (aqi <= 100)
            return "Moderate";

        if (aqi <= 150)
            return "Unhealthy for Sensitive Groups";

        if (aqi <= 200)
            return "Unhealthy";

        if (aqi <= 300)
            return "Very Unhealthy";

        return "Hazardous";
    }
}