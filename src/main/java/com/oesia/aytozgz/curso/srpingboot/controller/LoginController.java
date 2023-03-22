package com.oesia.aytozgz.curso.srpingboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping()
public class LoginController {

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
}
