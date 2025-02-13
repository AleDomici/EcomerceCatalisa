package com.catalisa.ecomerce.zup.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/") // Mapeia a raiz da aplicação
    public String home() {
        return "Bem-vindo ao iCrud!";
    }
}
