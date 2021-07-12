package com.backend.foto.service;

import java.util.List;

import com.backend.foto.document.Foto;

public interface FotoService {
    public List<Foto> readAll() throws Exception;
    public Foto readById(String id) throws Exception;
    public Foto create(Foto foto) throws Exception;
    public Foto update(Foto foto) throws Exception;
    public void deleteById(String id) throws Exception;

    public List<Foto> findByIDCliente(Integer id) throws Exception;
    
}
