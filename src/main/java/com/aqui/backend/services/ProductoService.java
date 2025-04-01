package com.aqui.backend.services;

import java.util.List;

import org.springframework.stereotype.Service;
import com.aqui.backend.models.Producto;
import com.aqui.backend.repositories.ProductoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class ProductoService {
    
    private final ProductoRepository productoRepository;

    //todos los productos
    public List<Producto> todosLosProductos() {
        return productoRepository.findAll();
    }

    public void guardarProducto(Producto producto) {
        productoRepository.save(producto);
    }

    public List<Producto> buscarPorCategoriaId(Long categoriaId) {
        return productoRepository.findByCategoriasId(categoriaId);    
    }

    public List<Producto> filtrarProductos(Long categoriaId, String nombre, Integer precio) {
        List<Producto> todas = productoRepository.findAll();

        return todas.stream()
        .filter(m -> categoriaId == null || m.getCategorias().stream().anyMatch(c -> c.getId().equals(categoriaId)))
        .filter(m -> nombre == null || m.getNombre().equalsIgnoreCase(nombre))
        .filter(m -> precio == null || m.getPrecio() <= precio)
        .toList();
    }

    public List<Producto> obtenerProductosPorIds(List<Long> ids) {
        return productoRepository.findByIdIn(ids);
    }

    public List<Producto> productosPorMarca(Long categoriaId) {
        return productoRepository.findByCategoriasId(categoriaId);
    }

    public Producto productoPorId(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

}
