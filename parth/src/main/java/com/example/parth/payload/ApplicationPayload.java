package com.example.parth.payload;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class ApplicationPayload {

    private ZonedDateTime timestamp;
    private String message;
    private HttpStatus httpStatus;

    public ApplicationPayload() {
    }

    public ApplicationPayload(ZonedDateTime timestamp, String message, HttpStatus httpStatus) {
        this.timestamp = timestamp;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
