package com.shivakumar.aqi_search_engine.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CityNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleCityNotFound(
            CityNotFoundException ex
    ) {

        return new ResponseEntity<>(
                new ErrorResponseDTO(
                        ex.getMessage(),
                        LocalDateTime.now().toString()
                ),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(ExternalAPIException.class)
    public ResponseEntity<ErrorResponseDTO> handleExternalAPI(
            ExternalAPIException ex
    ) {

        return new ResponseEntity<>(
                new ErrorResponseDTO(
                        ex.getMessage(),
                        LocalDateTime.now().toString()
                ),
                HttpStatus.BAD_GATEWAY
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleGeneric(
            Exception ex
    ) {

        return new ResponseEntity<>(
                new ErrorResponseDTO(
                        ex.getMessage(),
                        LocalDateTime.now().toString()
                ),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}