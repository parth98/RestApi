package com.example.parth.payload;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class LoginSuccessPayload extends ApplicationPayload{

    private Payload payload;

    public LoginSuccessPayload(ZonedDateTime timestamp, String message, HttpStatus httpStatus) {
        super(timestamp, message, httpStatus);
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }
}
