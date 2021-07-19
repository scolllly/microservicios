package com.backend.cliente.client;

import java.util.List;

import com.backend.cliente.modelo.FotoDto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "foto-service", fallback = FotoClientFallback.class )
// @RequestMapping("/fotos")
public interface FotoClient {

    @GetMapping("/fotos")
    public ResponseEntity<List<FotoDto>> readAll(@RequestParam(name = "id_cliente", required = false) Integer idCliente) throws Exception;
    
}
