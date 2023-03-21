package com.oesia.aytozgz.curso.srpingboot.model.jpa.service;

import java.util.List;
import java.util.Optional;

import com.oesia.aytozgz.curso.srpingboot.model.entity.Producto;

public interface ProductoService {
	
	/**
	 * Guarda el producto
	 * 
	 * @param producto
	 */
	void guardar(Producto producto);
	
	/**
	 * Recupera la lista completa de productos
	 * 
	 * @return
	 */
	List<Producto> obtenerTodosProductos();
	
	/**
	 * Devuelve el producto correspondiente al id si existe
	 * 
	 * @param id Id del producto
	 * @return
	 */
	Optional<Producto> obtenerProducto(Integer id);
	
	/**
	 * Elimina el producto correspondiente al id
	 * 
	 * @param id Id del producto
	 */
	void eliminar(Integer id);

	/**
	 * Busca productos cuyo nombre contengan el parametro entrante "nombre"
	 *
	 * @param nombre parámetro de búsqueda
	 * @return posible listado con coincidencias
	 */
	List<Producto> buscarPorNombre(final String nombre);
	
}
