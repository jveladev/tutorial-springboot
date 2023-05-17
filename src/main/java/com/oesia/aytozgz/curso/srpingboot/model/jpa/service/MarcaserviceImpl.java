package com.oesia.aytozgz.curso.srpingboot.model.jpa.service;

import com.oesia.aytozgz.curso.srpingboot.model.entity.Marca;
import com.oesia.aytozgz.curso.srpingboot.model.jpa.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaserviceImpl implements MarcaService{

    @Autowired
    private MarcaRepository marcaRepository;
    @Override
    public List<Marca> findAll() {
        return marcaRepository.findAll();
    }


}
