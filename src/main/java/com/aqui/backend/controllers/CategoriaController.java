package com.aqui.backend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aqui.backend.services.CategoriaService;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
@RequiredArgsConstructor
@RequestMapping("/categorias")

public class CategoriaController {

    private final CategoriaService categoriaService;

    @GetMapping
    public String mostrarCategorias(Model model) {
        model.addAttribute("categorias", categoriaService.todaslasCategorias());

        return "categorias";
    }
    
    
}
