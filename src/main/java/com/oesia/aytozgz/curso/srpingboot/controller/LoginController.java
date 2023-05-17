package com.oesia.aytozgz.curso.srpingboot.controller;

import com.oesia.aytozgz.curso.srpingboot.model.entity.Producto;
import com.oesia.aytozgz.curso.srpingboot.model.entity.User;
import com.oesia.aytozgz.curso.srpingboot.model.jpa.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
@RequestMapping()
public class LoginController {

    private static final String VISTA_REGISTRO_USUARIO = "registro";

    @Value("${aplicacion.nombre}")
    private String nombreAplicacion;

    @Autowired
    IUserService userService;

    @RequestMapping("/login")
    public String login(Map<String, Object> model, @Value("${aplicacion.nombre}") final String nombreAplicacion) {
        model.put("titulo", nombreAplicacion);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        }
        return "redirect:" + "/productos/lista";
    }

    @RequestMapping
    public String rootPath() {
        return "redirect:" + "/login";
    }

    @GetMapping("/cargarVistaRegistro")
    public String cargarVistaRegistro(Map<String, Object> model) {
        User user = new User();
        model.put("user", user);
        model.put("titulo", nombreAplicacion);

        return VISTA_REGISTRO_USUARIO;
    }

    @PostMapping("/registro")
    public String registro(User nuevoUsuario) {
        nuevoUsuario.setRoles(Arrays.asList(/*"ROLE_ADMIN", */"ROLE_USER"));
        userService.saveUser(nuevoUsuario);
        return "redirect:" + "/login";
    }
}
