package com.catalisa.ecomerce.zup.repository;

import com.catalisa.ecomerce.zup.model.Cliente;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepository {
    private final List<Cliente> clientes = new ArrayList<>();

    public List<Cliente> findAll() {
        return clientes;
    }

    public Optional<Cliente> findByCpf(String cpf) {
        return clientes.stream()
                .filter(c -> c.getCpf().equals(cpf))
                .findFirst();
    }

    public Optional<Cliente> findByEmail(String email) {
        return clientes.stream()
                .filter(c -> c.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }

    public void save(Cliente cliente) {
        clientes.add(cliente);
    }
}