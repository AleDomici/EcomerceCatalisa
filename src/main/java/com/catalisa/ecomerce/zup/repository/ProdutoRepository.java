package com.catalisa.ecomerce.zup.repository;

import com.catalisa.ecomerce.zup.model.Produto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProdutoRepository {
    private final List<Produto> produtos = new ArrayList<>();
    private Long idCounter = 1L; // Contador para gerar IDs automaticamente

    // Retorna todos os produtos
    public List<Produto> findAll() {
        return produtos;
    }

    // Busca um produto pelo ID
    public Optional<Produto> findById(Long id) {
        return produtos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    // Busca um produto pelo nome
    public Optional<Produto> findByNome(String nome) {
        return produtos.stream()
                .filter(p -> p.getNome().equalsIgnoreCase(nome))
                .findFirst();
    }

    // Salva ou atualiza um produto
    public void save(Produto produto) {
        if (produto.getId() == null) {
            produto.setId(idCounter++); // Define o ID automaticamente se for um novo produto
            produtos.add(produto);
        } else {
            // Atualiza o produto existente
            produtos.replaceAll(p -> p.getId().equals(produto.getId()) ? produto : p);
        }
    }

    // Remove um produto
    public void delete(Produto produto) {
        produtos.remove(produto);
    }
}