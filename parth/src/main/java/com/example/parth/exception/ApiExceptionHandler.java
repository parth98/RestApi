package com.example.parth.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;


@ControllerAdvice
@RestController
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception e) {
        ApiExceptionResponse exceptionResponse = new ApiExceptionResponse(
                ZonedDateTime.now(ZoneId.of("Z")),
                e.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                e
        );
        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handleApiRequestNotFoundException(NotFoundException e){
         ApiExceptionResponse exceptionResponse = new ApiExceptionResponse(
                ZonedDateTime.now(ZoneId.of("Z")),
                e.getMessage(),
                HttpStatus.NOT_FOUND,
                e
        );
        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> handleApiRequestBadRequestException(BadRequestException e){
        ApiExceptionResponse exceptionResponse = new ApiExceptionResponse(
                ZonedDateTime.now(ZoneId.of("Z")),
                e.getMessage(),
                HttpStatus.BAD_REQUEST,
                e
        );
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Object> handleApiRequestForbiddenException(AccessDeniedException e){
        ApiExceptionResponse exceptionResponse = new ApiExceptionResponse(
                ZonedDateTime.now(ZoneId.of("Z")),
                e.getMessage(),
                HttpStatus.FORBIDDEN,
                e
        );
        return new ResponseEntity(exceptionResponse, HttpStatus.FORBIDDEN);
    }

}
