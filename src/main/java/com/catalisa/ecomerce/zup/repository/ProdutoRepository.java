package com.catalisa.ecomerce.zup.repository;

import com.catalisa.ecomerce.zup.model.Produto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProdutoRepository {
    private final List<Produto> produtos = new ArrayList<>();

    public List<Produto> findAll() {
        return produtos;
    }

    public Optional<Produto> findByNome(String nome) {
        return produtos.stream()
                .filter(p -> p.getNome().equals(nome))
                .findFirst();
    }

    public void save(Produto produto) {
        produtos.add(produto);
    }

    public void deleteByNome(String nome) {
        produtos.removeIf(p -> p.getNome().equals(nome));
    }
}
