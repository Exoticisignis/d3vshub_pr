package com.example.infrastructure.api;

import com.example.infrastructure.api.errors.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class BaseController {
    @ExceptionHandler(NoSuchElementFoundException.class)
    public ResponseEntity<Object> handleNoSuchElementException(NoSuchElementFoundException ex){
        List<String> details = new ArrayList<String>();
        details.add(ex.getMessage());

        ApiError err = new ApiError(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND,
                "Resource Not Found" ,
                details);

        return ResponseEntityBuilder.build(err);
    }

    @ExceptionHandler(NullObjectInRequestBodyEcxeption.class)
    public ResponseEntity<Object> handleNullObjectRequestException(NullObjectInRequestBodyEcxeption ex){
        List<String> details = new ArrayList<String>();
        details.add(ex.getMessage());

        ApiError err = new ApiError(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST,
                "Null object for post method" ,
                details);

        return ResponseEntityBuilder.build(err);
    }

    @ExceptionHandler(UserExistsException.class)
    public ResponseEntity<Object> handleUserExistsException(UserExistsException ex){
        List<String> details = new ArrayList<String>();
        details.add(ex.getMessage());

        ApiError err = new ApiError(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST,
                ex.getMessage() ,
                details);

        return ResponseEntityBuilder.build(err);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {

        List<String> details = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getObjectName()+ " : " +error.getDefaultMessage())
                .collect(Collectors.toList());

        ApiError err = new ApiError(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST,
                "Validation Errors" ,
                details);

        return ResponseEntityBuilder.build(err);
    }
    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> handleAll(
            Exception ex,
            WebRequest request) {

        List<String> details = new ArrayList<String>();
        details.add(ex.getLocalizedMessage());

        ApiError err = new ApiError(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST,
                "Error occurred" ,
                details);

        return ResponseEntityBuilder.build(err);
    }
}
