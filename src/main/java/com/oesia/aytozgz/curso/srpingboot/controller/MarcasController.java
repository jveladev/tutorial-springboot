package com.oesia.aytozgz.curso.srpingboot.controller;

import com.oesia.aytozgz.curso.srpingboot.model.jpa.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("marcas")
public class MarcasController {

    public static final String VISTA_LISTA_MARCAS = "listaMarcas";

    @Autowired
    private MarcaService marcaService;

    @Value("${aplicacion.nombre}")
    private String nombreAplicacion;

    @GetMapping(value = "/lista")
    public String listar(final Model model) {
        model.addAttribute("titulo", nombreAplicacion);
        model.addAttribute("marcas", marcaService.findAll());
        return VISTA_LISTA_MARCAS;
    }
}
