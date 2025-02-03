package com.catalisa.ecomerce.zup.services;


import com.catalisa.ecomerce.zup.model.Produto;
import com.catalisa.ecomerce.zup.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public void cadastrarProduto(Produto produto) {
        if (produtoRepository.findByNome(produto.getNome()).isPresent()) {
            throw new IllegalArgumentException("Já existe um produto com esse nome.");
        }
        if (produto.getPreco() <= 0 || produto.getQuantidade() < 0) {
            throw new IllegalArgumentException("Preço ou quantidade inválidos.");
        }
        produtoRepository.save(produto);
    }

    public void deletarProduto(String nome) {
        produtoRepository.deleteByNome(nome);
    }
}
