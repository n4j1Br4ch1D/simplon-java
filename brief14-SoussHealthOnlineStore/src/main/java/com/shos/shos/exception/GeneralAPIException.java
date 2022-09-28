package com.shos.shos.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeneralAPIException extends RuntimeException {

    private HttpStatus status;
    private String message;

    public GeneralAPIException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public GeneralAPIException(String message, HttpStatus status, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }
}
