package com.catalisa.ecomerce.zup.controllers;

import com.catalisa.ecomerce.zup.model.Cliente;
import com.catalisa.ecomerce.zup.services.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente) {
        try {
            clienteService.cadastrarCliente(cliente);
            return ResponseEntity.ok(cliente); // Retorna o objeto criado
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null); // Retorna null em caso de erro *por enquanto
        }
    }

    @PutMapping("/{cpf}")
    public ResponseEntity<String> atualizarCliente(@PathVariable String cpf, @RequestBody Cliente clienteAtualizado) {
        try {
            clienteService.atualizarCliente(cpf, clienteAtualizado);
            return ResponseEntity.ok("Cliente atualizado com sucesso.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Endpoint para listar todos os clientes
    @GetMapping
    public ResponseEntity<List<Cliente>> listarTodosClientes() {
        List<Cliente> clientes = clienteService.listarTodosClientes();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Cliente> buscarClientePorCpf(@PathVariable String cpf) {
        try {
            Cliente cliente = clienteService.buscarClientePorCpf(cpf);
            return ResponseEntity.ok(cliente); // O cliente retornado já inclui o ID
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}