package com.example.infrastructure.api.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NullObjectInRequestBodyEcxeption extends RuntimeException{
    public NullObjectInRequestBodyEcxeption(String msg){
        super(msg);
    }
}
