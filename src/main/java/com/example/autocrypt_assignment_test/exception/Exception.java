package com.example.autocrypt_assignment_test.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
public class Exception {

    private String errorMessage;
    private HttpStatus httpStatus;
}