package com.oesia.aytozgz.curso.srpingboot.controller;

import com.oesia.aytozgz.curso.srpingboot.model.entity.Producto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("productos")
public class ProductoController {
	
	public static final String VISTA_LISTA = "lista";
	public static final String VISTA_ALTA_PRODUCTO = "altaProducto";
	
	@Value("${aplicacion.nombre}")
	private String nombreAplicacion;

	@GetMapping(value = "/lista")
	public String listar(final Model model, final @RequestParam(required = false)  String textoBusqueda) {
		model.addAttribute("titulo", nombreAplicacion);
		return VISTA_LISTA;
	}

	@GetMapping("/crear")
	public String crear(Map<String, Object> model) {
		Producto producto = new Producto();
		model.put("producto", producto);
		model.put("titulo", nombreAplicacion);
		return VISTA_ALTA_PRODUCTO;
	}
	
	@PostMapping("/guardar")
	public String guardar(Producto producto) {
		return "redirect:" + VISTA_LISTA;
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") Integer idProducto) {
		return "redirect:../" + VISTA_LISTA;
	}

}
