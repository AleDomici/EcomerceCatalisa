package com.catalisa.ecomerce.zup.services;

import com.catalisa.ecomerce.zup.model.Cliente;
import com.catalisa.ecomerce.zup.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void cadastrarCliente(Cliente cliente) {
        validarDadosCliente(cliente);

        if (clienteRepository.findByCpf(cliente.getCpf()).isPresent()) {
            throw new IllegalArgumentException("CPF já cadastrado.");
        }

        if (clienteRepository.findByEmail(cliente.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email já cadastrado.");
        }

        clienteRepository.save(cliente);
    }

    public void atualizarCliente(String cpf, Cliente clienteAtualizado) {
        validarDadosCliente(clienteAtualizado);

        Cliente clienteExistente = clienteRepository.findByCpf(cpf)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado."));

        if (!clienteExistente.getEmail().equals(clienteAtualizado.getEmail())
                && clienteRepository.findByEmail(clienteAtualizado.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email já cadastrado.");
        }

        clienteExistente.setNome(clienteAtualizado.getNome());
        clienteExistente.setEmail(clienteAtualizado.getEmail());
        clienteExistente.setCpf(clienteAtualizado.getCpf());

        clienteRepository.save(clienteExistente);
    }

    public Cliente buscarClientePorCpf(String cpf) {
        return clienteRepository.findByCpf(cpf)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado."));
    }

    public List<Cliente> listarTodosClientes() {
        return clienteRepository.findAll();
    }

    private void validarDadosCliente(Cliente cliente) {
        if (cliente.getNome() == null || cliente.getNome().isEmpty()) {
            throw new IllegalArgumentException("O nome do cliente é obrigatório.");
        }

        if (cliente.getCpf() == null || !isCpfValido(cliente.getCpf())) {
            throw new IllegalArgumentException("CPF inválido.");
        }

        if (cliente.getEmail() == null || !isEmailValido(cliente.getEmail())) {
            throw new IllegalArgumentException("Email inválido.");
        }
    }

    private boolean isCpfValido(String cpf) {
        // Validação simples de CPF
        return cpf.matches("\\d{11}");
    }

    private boolean isEmailValido(String email) {
        // Validação simples de email usando regex
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return Pattern.compile(emailRegex).matcher(email).matches();
    }
}