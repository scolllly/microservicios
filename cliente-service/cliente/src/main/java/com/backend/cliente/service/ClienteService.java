package com.backend.cliente.service;

import java.util.List;

import com.backend.cliente.entity.Cliente;

public interface ClienteService {

    public List<Cliente> readAll() throws Exception;
    public Cliente readById(Integer id) throws Exception;
    public Cliente create(Cliente cliente) throws Exception;
    public Cliente update(Cliente cliente) throws Exception;
    public void deleteById(Integer id) throws Exception;


    
}
