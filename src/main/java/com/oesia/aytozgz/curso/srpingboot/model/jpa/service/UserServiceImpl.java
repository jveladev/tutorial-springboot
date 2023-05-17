package com.oesia.aytozgz.curso.srpingboot.model.jpa.service;

import com.oesia.aytozgz.curso.srpingboot.model.entity.User;
import com.oesia.aytozgz.curso.srpingboot.model.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements IUserService, UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Integer saveUser(User user) {
        String passwd = user.getPassword();
        String encodedPasswod = passwordEncoder.encode(passwd);
        user.setPassword(encodedPasswod);
        user = userRepo.save(user);
        return user.getId();
    }

    @Override
    public Optional<User> findUserByName(String name) {
        return userRepo.findUserByName(name);
    }

    @Override
    public UserDetails loadUserByUsername(String nombre)
            throws UsernameNotFoundException {

        Optional<User> opt = userRepo.findUserByName(nombre);

        if (!opt.isPresent()) {
            throw new UsernameNotFoundException("Usuario con nombre: " + nombre + " no encontrado !");
        } else {
            User user = opt.get();
            return new org.springframework.security.core.userdetails.User(
                    user.getName(),
                    user.getPassword(),
                    user.getRoles()
                            .stream()
                            .map(role -> new SimpleGrantedAuthority(role))
                            .collect(Collectors.toSet())
            );
        }
    }

}