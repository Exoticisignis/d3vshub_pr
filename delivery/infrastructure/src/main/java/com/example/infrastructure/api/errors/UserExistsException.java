package com.example.infrastructure.api.errors;

import javax.security.sasl.AuthenticationException;

public class UserExistsException extends AuthenticationException {
    public UserExistsException(String message){
        super(message);
    }
}
