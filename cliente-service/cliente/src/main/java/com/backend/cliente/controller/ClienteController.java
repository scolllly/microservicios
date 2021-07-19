package com.backend.cliente.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.backend.cliente.client.FotoClient;
import com.backend.cliente.converter.ClienteConverter;
import com.backend.cliente.dto.ClienteDto;
import com.backend.cliente.dto.ClienteRegistrarDto;
import com.backend.cliente.entity.Cliente;
import com.backend.cliente.modelo.FotoDto;
import com.backend.cliente.service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteConverter clienteConverter;

    @Autowired
    private FotoClient fotoClient;

    @GetMapping
    public ResponseEntity< List<ClienteDto>> readAll() throws Exception{
        List<Cliente> clienteLista = clienteService.readAll();
        List<ClienteDto> clienteDtoLista =  clienteConverter.convertirEntityToDto(clienteLista);


        List<FotoDto> fotoLista = new ArrayList<>();
        // List<Integer> idClienteLista = new ArrayList<>();

        if(!clienteDtoLista.isEmpty()){

            clienteDtoLista.stream().forEach(clienteDto -> {

                try{
                    clienteDto.setFotos(fotoClient.readAll(clienteDto.getId()).getBody());

                }catch(Exception e){
                    // return e;    
                }
                
                // idClienteLista.add(cliente.getId()); 

            });
        }

        return new ResponseEntity<List<ClienteDto>>(clienteDtoLista , HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDto> readById(@PathVariable(name = "id") Integer id) throws Exception{
        Cliente cliente = clienteService.readById(id);
        ClienteDto clienteDto =  clienteConverter.convertirEntityToDto(cliente);

        return new ResponseEntity<ClienteDto>(clienteDto , HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClienteDto> readById(@Valid @RequestBody ClienteRegistrarDto clienteDto) throws Exception{

        System.out.println(clienteDto);
        Cliente cliente =  clienteConverter.convertirDtoToEntity(clienteDto);
        System.out.println(cliente);
        ClienteDto clienteDtoRegistrado = clienteConverter.convertirEntityToDto(clienteService.create(cliente));
        return new ResponseEntity<ClienteDto>(clienteDtoRegistrado , HttpStatus.OK);
    }
    
}
