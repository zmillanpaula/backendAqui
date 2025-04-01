package com.aqui.backend.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aqui.backend.models.Producto;
import com.aqui.backend.services.CategoriaService;
import com.aqui.backend.services.ProductoService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequiredArgsConstructor
@RequestMapping("/productos")

public class ProductoController {
    
    private final ProductoService productoService;
    private final CategoriaService categoriaService;

    @GetMapping
    public String mostrarProducto(@RequestParam (required = false) Long categoriaId, @RequestParam(required = false) String nombre, @RequestParam (required = false) Integer precio, Model model) {
    List<Producto> productosFiltrados = productoService.filtrarProductos(categoriaId, nombre, precio);

    model.addAttribute("productos", productosFiltrados);
    model.addAttribute("categorias", categoriaService.todaslasCategorias());
    model.addAttribute("categoriaSeleccionada", categoriaId);
    model.addAttribute("nombre", nombre);
    model.addAttribute("precio", precio);
    return "productos";
    }

    @GetMapping("/por-marca")
    @ResponseBody
    public List<Producto> getProductosPorCategoria(@RequestParam Long categoriaId){
        return productoService.productosPorMarca(categoriaId);
    }


    
    
}
