package com.shivakumar.aqi_search_engine.client;

import com.shivakumar.aqi_search_engine.exceptions.ExternalAPIException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.Map;

@Component
public class AQICNClient {

    private final RestClient restClient;

    @Value("${aqi.api.base-url}")
    private String baseUrl;

    @Value("${aqi.api.token}")
    private String token;

    public AQICNClient() {
        this.restClient = RestClient.create();
    }

    public Map<String, Object> getAQIData(String city) {

        try {

            String url =
                    baseUrl +
                            "/feed/" +
                            city +
                            "/?token=" +
                            token;

            return restClient
                    .get()
                    .uri(url)
                    .retrieve()
                    .body(Map.class);

        } catch (Exception ex) {

            throw new ExternalAPIException(
                    "Unable to fetch AQI data from external provider."
            );
        }
    }
}