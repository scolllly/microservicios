package com.backend.cliente.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionResponse {

    private String mensaje;
    private String detalle;
    private LocalDateTime fecha;
    
}
