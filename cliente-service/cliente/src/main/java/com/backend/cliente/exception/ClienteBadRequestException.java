package com.backend.cliente.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ClienteBadRequestException extends RuntimeException{

    public ClienteBadRequestException(String mensaje){
        super(mensaje);

    }
    
}
