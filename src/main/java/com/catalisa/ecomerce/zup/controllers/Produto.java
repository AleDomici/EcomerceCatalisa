package com.catalisa.ecomerce.zup.controllers;

public class Produto {
    private String nome;
    private double preco;
    private int quantidade;

    //construtor, getters e setters
    public Produto(String nome, double preco,int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void SetNome(String nome) {
        this.nome = nome;
    }

    public  double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
