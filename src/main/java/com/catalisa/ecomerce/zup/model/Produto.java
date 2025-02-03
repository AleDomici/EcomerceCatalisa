package com.catalisa.ecomerce.zup.model;

public class Produto {
    private Long id; // Campo para o ID
    private String nome;
    private Double preco;
    private int quantidade;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        if (preco <= 0) {
            throw new IllegalArgumentException("O preço deve ser maior que 0.");
        }
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade < 0) {
            throw new IllegalArgumentException("A quantidade deve ser maior ou igual a 0.");
        }
        this.quantidade = quantidade;
    }
}
