package com.backend.foto.converter;

import java.util.ArrayList;
import java.util.List;

import com.backend.foto.document.Foto;
import com.backend.foto.dto.FotoDto;
import com.backend.foto.dto.FotoRegistrarDto;

import org.springframework.stereotype.Component;

@Component
public class FotoConverter {

    // Recibe carta y las transforma en carta dto
    public FotoDto convertirEntityToDto(Foto foto){
        return FotoDto.builder()
        .id(foto.getId())
        .idCliente(foto.getIdCliente())
        .foto(foto.getFoto())
        .build();
       
    }

    // Recibe lista de cartas y las transforma en lista de cartas dto
    public List<FotoDto> convertirEntityToDto(List<Foto> fotoLista){
        List<FotoDto> fotoDtoLista = new ArrayList<>();
        fotoLista.stream().forEach(foto -> {

            fotoDtoLista.add(convertirEntityToDto(foto));

        });

        return fotoDtoLista;
       
    }

    // Recibe carta y las transforma en carta dto
    public Foto convertirDtoToEntity(FotoDto fotoDto){
        return Foto.builder()
        .id(fotoDto.getId())
        .idCliente(fotoDto.getIdCliente())
        .foto(fotoDto.getFoto())
        .build();
       
    }

    public Foto convertirDtoToEntity(FotoRegistrarDto fotoDto){
        return Foto.builder()
        .idCliente(fotoDto.getIdCliente())
        .foto(fotoDto.getFoto())
        .build();
       
    }

    // Recibe dto y las transforma en carta 
    public List<Foto> convertirDtoToEntity(List<FotoDto> fotoDtoLista){
        List<Foto> fotoLista = new ArrayList<>();
        fotoDtoLista.stream().forEach(dto -> {

            fotoLista.add(convertirDtoToEntity(dto));

        });

        return fotoLista;
       
    }
    
}
