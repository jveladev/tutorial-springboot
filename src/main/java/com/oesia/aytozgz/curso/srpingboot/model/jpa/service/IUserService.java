package com.oesia.aytozgz.curso.srpingboot.model.jpa.service;


import com.oesia.aytozgz.curso.srpingboot.model.entity.User;

import java.util.Optional;

public interface IUserService {

    Integer saveUser(User user);

    Optional<User> findUserByName(String name);

}
