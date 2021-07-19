package com.backend.cliente.service;

import java.util.List;

import com.backend.cliente.client.FotoClient;
import com.backend.cliente.entity.Cliente;
import com.backend.cliente.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {


    @Autowired
    private ClienteRepository clienteRepository; 

    @Override
    public List<Cliente> readAll() throws Exception{
        try{
            return clienteRepository.findAll();     
        }
        catch(Exception e){
            throw e;
        }
        
    }

    @Override
    public Cliente readById(Integer id) throws Exception{

        try{
            return clienteRepository.findById(id).orElse(null);   
        }
        catch(Exception e){
            throw e;
        }
        
    }

    @Override
    public Cliente create(Cliente cliente) throws Exception{

        try{
            // Cliente clienteBd = readById(cliente.getId());
            // if(clienteBd != null)
            // {
            //     return clienteBd;
            // }
            return clienteRepository.save(cliente);   
        }
        catch(Exception e){
            throw e;
        }

        
    }

    @Override
    public Cliente update(Cliente cliente) throws Exception{

        try{
            return clienteRepository.save(cliente);  
        }
        catch(Exception e){
            throw e;
        }
        
    }

    @Override
    public void deleteById(Integer id) throws Exception{

        try{
            clienteRepository.deleteById(id);
        }
        catch(Exception e){
            throw e;
        }
        
        
    }
    
}
