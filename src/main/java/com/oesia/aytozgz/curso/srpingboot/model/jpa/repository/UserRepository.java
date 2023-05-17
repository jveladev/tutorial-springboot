package com.oesia.aytozgz.curso.srpingboot.model.jpa.repository;


import com.oesia.aytozgz.curso.srpingboot.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findUserByName(String email);
}
