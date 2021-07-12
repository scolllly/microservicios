package com.backend.cliente.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClienteRegistrarDto {

    @NotBlank
    @NotNull
    private String nombre;

    @NotBlank
    @NotNull
    private String apellidos;

    @NotBlank
    @NotNull
    private String tipoIdentificacion;

    @NotBlank
    @NotNull
    private String numeroIdentificacion;

    @Min(0)
    private int edad;
    private String ciudad;
    
}
