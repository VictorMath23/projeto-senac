package com.senac.api.filmes_api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/index")  // Mapeamento para a página principal
    public String abrirPaginaPrincipal() {
        return "index";  // Nome do arquivo HTML da página principal
    }

    @GetMapping("/consulta")  // Mapeamento para a página consulta.html
    public String abrirPaginaConsulta() {
        return "consulta";  // Nome do arquivo HTML da página consulta
    }

    @GetMapping("/login")  // Mapeamento para a página login.html
    public String abrirPaginaLogin() {
        return "login";  // Nome do arquivo HTML da página login
    }
    
    @GetMapping("/admin")  // Mapeamento para a página login.html
    public String abrirPaginaAdmin() {
        return "admin";  // Nome do arquivo HTML da página login
    }
    
    

}