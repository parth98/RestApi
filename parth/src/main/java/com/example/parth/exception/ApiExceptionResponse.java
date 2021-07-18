package com.example.parth.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class ApiExceptionResponse {

    private final ZonedDateTime timestamp;
    private final String message;
    private final HttpStatus httpStatus;
    private final Throwable throwable;

    public ApiExceptionResponse(ZonedDateTime timestamp, String message, HttpStatus httpStatus, Throwable throwable) {
        this.timestamp = timestamp;
        this.message = message;
        this.httpStatus = httpStatus;
        this.throwable = throwable;
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

    public Throwable getThrowable() {
        return throwable;
    }
}
