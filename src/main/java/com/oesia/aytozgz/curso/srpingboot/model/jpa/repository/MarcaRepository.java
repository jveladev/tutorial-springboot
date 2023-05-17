package com.oesia.aytozgz.curso.srpingboot.model.jpa.repository;

import com.oesia.aytozgz.curso.srpingboot.model.entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Integer> {

}
