package com.oesia.aytozgz.curso.srpingboot.model.jpa.service;

import java.util.List;
import java.util.Optional;

import com.oesia.aytozgz.curso.srpingboot.model.jpa.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oesia.aytozgz.curso.srpingboot.model.entity.Producto;

@Service
public class ProductoServiceImpl implements ProductoService {
	
	@Autowired
	private ProductoRepository productoRepository;

	@Override
	public void guardar(Producto producto) {
		productoRepository.save(producto);
	}

	@Override
	public List<Producto> obtenerTodosProductos() {
		return productoRepository.findAll();
	}

	@Override
	public Optional<Producto> obtenerProducto(Integer id) {
		return productoRepository.findById(id);
	}

	@Override
	public void eliminar(Integer id) {
		productoRepository.deleteById(id);	
	}

	public List<Producto> buscarPorNombre(final String nombre) {
		return productoRepository.findAllByNombreLikeIgnoreCase(nombre);
	}



}
