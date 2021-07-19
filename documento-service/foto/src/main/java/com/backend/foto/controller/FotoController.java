package com.backend.foto.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.backend.foto.converter.FotoConverter;
import com.backend.foto.document.Foto;
import com.backend.foto.dto.FotoDto;
import com.backend.foto.dto.FotoRegistrarDto;
import com.backend.foto.service.FotoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("fotos")
public class FotoController {

    @Autowired
    private FotoService fotoService;

    @Autowired
    private FotoConverter fotoConverter;

    @GetMapping
    public ResponseEntity<List<FotoDto>> readAll(@RequestParam(name = "id_cliente", required = false) Integer idCliente) throws Exception{
        
        List<Foto> fotoLista = new ArrayList<>();

        if(idCliente != null){
            fotoLista = fotoService.findByIDCliente(idCliente);
        }
        else{
            fotoLista = fotoService.readAll();     
        }
       
        List<FotoDto> fotoDtoLista =  fotoConverter.convertirEntityToDto(fotoLista);

        return new ResponseEntity<List<FotoDto>>(fotoDtoLista , HttpStatus.OK);
    }


    @GetMapping("/id{id}")
    public ResponseEntity<FotoDto> readById(@PathVariable(name = "id") String id) throws Exception{
        Foto foto = fotoService.readById(id);
        FotoDto fotoDto =  fotoConverter.convertirEntityToDto(foto);

        return new ResponseEntity<FotoDto>(fotoDto , HttpStatus.OK);
    }

   

    @PostMapping
    public ResponseEntity<FotoDto> readById(@Valid @RequestBody FotoRegistrarDto clienteDto) throws Exception{

        Foto foto =  fotoConverter.convertirDtoToEntity(clienteDto);
        FotoDto fotoDtoRegistrado = fotoConverter.convertirEntityToDto(fotoService.create(foto));
        return new ResponseEntity<FotoDto>(fotoDtoRegistrado , HttpStatus.OK);
    }
    
}
