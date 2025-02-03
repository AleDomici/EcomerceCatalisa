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

    public List<Produto> findAll() {
        return produtos;
    }

    public Optional<Produto> findById(Long id) {
        return produtos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    public Optional<Produto> findByNome(String nome) {
        return produtos.stream()
                .filter(p -> p.getNome().equalsIgnoreCase(nome))
                .findFirst();
    }

    public void save(Produto produto) {
        produto.setId(idCounter++); // Define o ID automaticamente
        produtos.add(produto);
    }

    public void delete(Produto produto) {
        produtos.remove(produto);
    }
}