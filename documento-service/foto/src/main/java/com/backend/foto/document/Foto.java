package com.backend.foto.document;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "foto")
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Foto {

    @Id
    private String id;

    private Integer idCliente;
    private String foto;
    
}
