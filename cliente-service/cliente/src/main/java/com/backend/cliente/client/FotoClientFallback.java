package com.backend.cliente.client;

import java.util.ArrayList;
import java.util.List;

import com.backend.cliente.modelo.FotoDto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


@Component
public class FotoClientFallback implements FotoClient {

    @Override
    public ResponseEntity<List<FotoDto>> readAll(Integer idCliente) throws Exception {
        List<FotoDto> fotoDtoLista = new ArrayList<>();
        FotoDto fotoDto = FotoDto.builder()
                            .id("id")
                            .idCliente(0)
                            .foto("foto")
                            .build();
        fotoDtoLista.add(fotoDto);

        return new ResponseEntity<List<FotoDto>>(fotoDtoLista, HttpStatus.OK);
    }
    
}
