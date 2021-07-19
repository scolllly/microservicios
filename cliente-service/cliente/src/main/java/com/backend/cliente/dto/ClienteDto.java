package com.backend.cliente.dto;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.backend.cliente.modelo.FotoDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor @NoArgsConstructor
public class ClienteDto {

    private Integer id;
    private String nombreCompleto;

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

    private List<FotoDto> fotos;
    
}
