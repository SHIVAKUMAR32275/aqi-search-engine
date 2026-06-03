package com.shivakumar.aqi_search_engine.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponseDTO {

    private String message;

    private String timestamp;
}