package com.oesia.aytozgz.curso.srpingboot.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.oesia.aytozgz.curso.srpingboot.model.entity.Producto;
import com.oesia.aytozgz.curso.srpingboot.model.jpa.service.ProductoService;

@Controller
@RequestMapping("productos")
public class ProductoController {
	
	public static final String VISTA_LISTA = "lista";
	public static final String VISTA_ALTA_PRODUCTO = "altaProducto";
	
	@Value("${aplicacion.nombre}")
	private String nombreAplicacion;

	@Autowired
	private ProductoService productoService;
	
	@GetMapping(value = "/lista")
	public String listar(final Model model, final @RequestParam(required = false)  String textoBusqueda) {
		model.addAttribute("titulo", nombreAplicacion);
		if (textoBusqueda != null && !textoBusqueda.equals("")) {
			model.addAttribute("productos", productoService.buscarPorNombre("%" + textoBusqueda + "%"));
		} else {
			model.addAttribute("productos", productoService.obtenerTodosProductos());
		}

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
		productoService.guardar(producto);
		
		return "redirect:" + VISTA_LISTA;
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") Integer idProducto) {
		productoService.eliminar(idProducto);
		return "redirect:../" + VISTA_LISTA;
	}

}
