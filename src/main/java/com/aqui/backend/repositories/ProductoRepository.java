package com.aqui.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aqui.backend.models.Producto;
import com.aqui.backend.models.Categoria;


public interface ProductoRepository extends JpaRepository<Producto, Long> {
    
    List<Producto> findByIdIn(List<Long> ids);

    List<Producto> findByCategorias(List<Categoria> categorias);

    List<Producto> findByCategoriasId(Long categoriaId);

}
