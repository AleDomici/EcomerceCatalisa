package com.catalisa.ecomerce.zup.controllers;

import com.catalisa.ecomerce.zup.model.Compra;
import com.catalisa.ecomerce.zup.services.CompraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/compras")
public class CompraController {
    private final CompraService compraService;

    public CompraController(CompraService compraService) {
        this.compraService = compraService;
    }

    @PostMapping
    public ResponseEntity<String> registrarCompra(@RequestBody Compra compra) {
        try {
            compraService.registrarCompra(compra);
            return ResponseEntity.ok("Compra registrada com sucesso.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}