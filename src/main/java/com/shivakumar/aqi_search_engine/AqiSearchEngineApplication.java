package com.shivakumar.aqi_search_engine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class AqiSearchEngineApplication {

    public static void main(String[] args) {
        SpringApplication.run(
                AqiSearchEngineApplication.class,
                args
        );
    }
}