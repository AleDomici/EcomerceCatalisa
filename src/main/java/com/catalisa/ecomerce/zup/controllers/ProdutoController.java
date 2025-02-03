package com.catalisa.ecomerce.zup.controllers;

import com.catalisa.ecomerce.zup.model.Produto;
import com.catalisa.ecomerce.zup.repository.ProdutoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    // Endpoint para cadastrar um novo produto
    @PostMapping
    public ResponseEntity<String> cadastrarProduto(@RequestBody Produto produto) {
        produtoRepository.save(produto);
        return ResponseEntity.ok("Produto cadastrado com sucesso.");
    }

    // Endpoint para buscar produto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarProdutoPorId(@PathVariable Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para buscar produto por nome
    @GetMapping("/nome/{nome}")
    public ResponseEntity<Produto> buscarProdutoPorNome(@PathVariable String nome) {
        Optional<Produto> produto = produtoRepository.findByNome(nome);
        return produto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para listar todos os produtos
    @GetMapping
    public ResponseEntity<List<Produto>> listarProdutos() {
        return ResponseEntity.ok(produtoRepository.findAll());
    }

    // Endpoint para deletar um produto por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarProduto(@PathVariable Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isPresent()) {
            produtoRepository.delete(produto.get());
            return ResponseEntity.ok("Produto deletado com sucesso.");
        }
        return ResponseEntity.notFound().build();
    }
}