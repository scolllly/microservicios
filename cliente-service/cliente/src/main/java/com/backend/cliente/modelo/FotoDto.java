package com.backend.cliente.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class FotoDto {

    private String id;
    private Integer idCliente;
    private String foto;
    
}
