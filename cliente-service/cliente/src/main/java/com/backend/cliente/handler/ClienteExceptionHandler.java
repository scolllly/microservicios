package com.backend.cliente.handler;

import java.time.LocalDateTime;

import com.backend.cliente.exception.ClienteBadRequestException;
import com.backend.cliente.exception.ClienteNotFoundException;
import com.backend.cliente.exception.ExceptionResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@RestController
public class ClienteExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> hanlderAllExceptions(Exception exception, WebRequest webRequest){
        ExceptionResponse exceptionResponse = new ExceptionResponse(exception.getMessage(), webRequest.getDescription(false), LocalDateTime.now());
        return new ResponseEntity<Object>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(ClienteBadRequestException.class)
    public ResponseEntity<Object> hanlderAllExceptions(ClienteBadRequestException exception, WebRequest webRequest){
        ExceptionResponse exceptionResponse = new ExceptionResponse(exception.getMessage(), webRequest.getDescription(false), LocalDateTime.now());
        return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(ClienteNotFoundException.class)
    public ResponseEntity<Object> hanlderAllExceptions(ClienteNotFoundException exception, WebRequest webRequest){
        ExceptionResponse exceptionResponse = new ExceptionResponse(exception.getMessage(), webRequest.getDescription(false), LocalDateTime.now());
        return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);

    }
    
}
