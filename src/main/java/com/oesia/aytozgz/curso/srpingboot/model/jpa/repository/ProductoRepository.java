package com.oesia.aytozgz.curso.srpingboot.model.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oesia.aytozgz.curso.srpingboot.model.entity.Producto;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    List<Producto> findAllByNombreLikeIgnoreCase(final String nombre);

}
