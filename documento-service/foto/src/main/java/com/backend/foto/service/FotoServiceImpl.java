package com.backend.foto.service;

import java.util.List;

import com.backend.foto.document.Foto;
import com.backend.foto.repository.FotoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FotoServiceImpl implements FotoService {

    @Autowired
    private FotoRepository fotoRepository;

    @Override
    public List<Foto> readAll() throws Exception {
        try{
            return fotoRepository.findAll();    
        }
        catch(Exception e){
            throw e;
        }
        
    }

    @Override
    public Foto readById(String id) throws Exception {
        try{
            return fotoRepository.findById(id).orElse(null);    
        }
        catch(Exception e){
            throw e;
        }
    }

    @Override
    public Foto create(Foto foto) throws Exception {
        try{
            return fotoRepository.save(foto);    
        }
        catch(Exception e){
            throw e;
        }
    }

    @Override
    public Foto update(Foto foto) throws Exception {
        try{
            return fotoRepository.save(foto);    
        }
        catch(Exception e){
            throw e;
        }
    }

    @Override
    public void deleteById(String id) throws Exception {
        try{
             fotoRepository.deleteById(id);    
        }
        catch(Exception e){
            throw e;
        }
        
    }

    @Override
    public List<Foto> findByIDCliente(Integer id) throws Exception {
        try{
            return fotoRepository.findByIdCliente(id);    
       }
       catch(Exception e){
           throw e;
       }
    }

    @Override
    public List<Foto> findByIDClienteIn(List<Integer> idLista) throws Exception {
        try{
            return fotoRepository.findByIdClienteIn(idLista);    
       }
       catch(Exception e){
           throw e;
       }
    }
    
}
