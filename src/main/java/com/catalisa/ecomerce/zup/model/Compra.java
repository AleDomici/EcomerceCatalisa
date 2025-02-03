package com.catalisa.ecomerce.zup.model;

public class Compra {
    private String cpfCliente;
    private String nomeProduto;
    private int quantidade;

    // Construtor, getters e setters
    public Compra(String cpfCliente, String nomeProduto, int quantidade){
        this.cpfCliente = cpfCliente;
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
