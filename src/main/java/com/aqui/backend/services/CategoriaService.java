package com.aqui.backend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aqui.backend.models.Categoria;
import com.aqui.backend.repositories.CategoriaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class CategoriaService {
    
    private final CategoriaRepository categoriaRepository;

    public void guardarCategoria(Categoria categoria){
        categoriaRepository.save(categoria);
    }

    public List<Categoria> todaslasCategorias() {
        return
        categoriaRepository.findAll();
    }
}
