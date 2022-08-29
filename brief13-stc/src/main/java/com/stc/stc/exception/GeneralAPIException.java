package com.stc.stc.exception;

import org.springframework.http.HttpStatus;

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

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
