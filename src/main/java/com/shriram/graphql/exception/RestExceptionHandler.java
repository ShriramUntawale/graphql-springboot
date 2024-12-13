package com.shriram.graphql.exception;

import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(PlayerNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND) // Optional if ResponseEntity is used
    public ResponseEntity<Map<String, String>> handlePlayerNotFoundException(PlayerNotFoundException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}