package com.catalisa.ecomerce.zup.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class Compra {
    @NotNull(message = "O CPF do cliente é obrigatório.")
    private String cpfCliente;

    @NotNull(message = "O ID do produto é obrigatório.")
    private Long idProduto;

    @Positive(message = "A quantidade deve ser maior que 0.")
    private int quantidade;

    // Getters e Setters
    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
