package com.backend.cliente.converter;

import java.util.ArrayList;
import java.util.List;

import com.backend.cliente.dto.ClienteDto;
import com.backend.cliente.dto.ClienteRegistrarDto;
import com.backend.cliente.entity.Cliente;

import org.springframework.stereotype.Component;

@Component
public class ClienteConverter {
    

    // Recibe carta y las transforma en carta dto
    public ClienteDto convertirEntityToDto(Cliente cliente){
        return ClienteDto.builder()
        .id(cliente.getId())
        .nombreCompleto(cliente.getNombre() + " " + cliente.getApellidos())
        .nombre(cliente.getNombre())
        .apellidos(cliente.getApellidos())
        .tipoIdentificacion(cliente.getTipoIdentificacion())
        .numeroIdentificacion(cliente.getNumeroIdentificacion())
        .edad(cliente.getEdad())
        .ciudad(cliente.getCiudad())
        .build();
       
    }

    // Recibe lista de cartas y las transforma en lista de cartas dto
    public List<ClienteDto> convertirEntityToDto(List<Cliente> clienteLista){
        List<ClienteDto> clienteDtoLista = new ArrayList<>();
        clienteLista.stream().forEach(cliente -> {

            clienteDtoLista.add(convertirEntityToDto(cliente));

        });

        return clienteDtoLista;
       
    }

    // Recibe carta y las transforma en carta dto
    public Cliente convertirDtoToEntity(ClienteDto clienteDto){
        return Cliente.builder()
        .id(clienteDto.getId())
        .nombre(clienteDto.getNombre())
        .apellidos(clienteDto.getApellidos())
        .tipoIdentificacion(clienteDto.getTipoIdentificacion())
        .numeroIdentificacion(clienteDto.getNumeroIdentificacion())
        .edad(clienteDto.getEdad())
        .ciudad(clienteDto.getCiudad())
        .build();
       
    }

    public Cliente convertirDtoToEntity(ClienteRegistrarDto clienteDto){
        return Cliente.builder()
        .nombre(clienteDto.getNombre())
        .apellidos(clienteDto.getApellidos())
        .tipoIdentificacion(clienteDto.getTipoIdentificacion())
        .numeroIdentificacion(clienteDto.getNumeroIdentificacion())
        .edad(clienteDto.getEdad())
        .ciudad(clienteDto.getCiudad())
        .build();
       
    }

    // Recibe dto y las transforma en carta 
    public List<Cliente> convertirDtoToEntity(List<ClienteDto> clienteDtoLista){
        List<Cliente> clienteLista = new ArrayList<>();
        clienteDtoLista.stream().forEach(dto -> {

            clienteLista.add(convertirDtoToEntity(dto));

        });

        return clienteLista;
       
    }
}
