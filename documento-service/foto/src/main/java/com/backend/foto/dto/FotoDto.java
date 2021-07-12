package com.backend.foto.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class FotoDto {

    @NotNull
    private String id;

    @NotNull
    private Integer idCliente;
    private String foto;
    
}
