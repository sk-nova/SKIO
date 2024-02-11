package com.skio;

import com.skio.error.APIError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    // Custom Exception Handlers here


    // General Exception Handler
    @ExceptionHandler({Exception.class})
    public ResponseEntity<APIError> genericException(
            Exception ex,
            HttpServletRequest request) {

        log.error("exception : " +
                ex.getLocalizedMessage() +
                " for " +
                request.getRequestURI());

        return new ResponseEntity<>(
                APIError.builder()
                        .errorMessage(ex.getLocalizedMessage())
                        .errorCode(HttpStatus.INTERNAL_SERVER_ERROR.toString())
                        .request(request.getRequestURI())
                        .requestType(request.getMethod())
                        .customMessage("Could not process request")
                        .build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}