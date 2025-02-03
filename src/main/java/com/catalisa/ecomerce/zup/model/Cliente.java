package com.catalisa.ecomerce.zup.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class Cliente {
    @NotBlank(message = "O nome do cliente não pode estar vazio.")
    private String nome;

    @Pattern(regexp = "\\d{11}", message = "CPF inválido. Deve conter 11 dígitos.")
    private String cpf;

    @Email(message = "Email inválido.")
    private String email;

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}