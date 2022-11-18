package com.rifqimuhammadaziz.apimedicalrecordsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class MethodArgumentNotValidExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        final Map<String, String> errorDetails = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(
                error -> errorDetails.put(error.getField(), error.getDefaultMessage())
        );
        return errorDetails;
    }
}
