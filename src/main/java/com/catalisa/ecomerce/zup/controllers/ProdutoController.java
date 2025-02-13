package com.catalisa.ecomerce.zup.controllers;

import com.catalisa.ecomerce.zup.model.Produto;
import com.catalisa.ecomerce.zup.services.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoService produtoService;

    // Injeção de dependência via construtor
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    // Endpoint para cadastrar um novo produto
    @PostMapping
    public ResponseEntity<Produto> cadastrarProduto(@RequestBody Produto produto) {
        try {
            produtoService.cadastrarProduto(produto);
            return ResponseEntity.ok(produto); // Retorna o objeto criado
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null); // Retorna null em caso de erro *por enquanto
        }
    }

    // Endpoint para buscar produto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarProdutoPorId(@PathVariable Long id) {
        return produtoService.listarProdutos().stream()
                .filter(produto -> produto.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint para buscar produto por nome
    @GetMapping("/nome/{nome}")
    public ResponseEntity<Produto> buscarProdutoPorNome(@PathVariable String nome) {
        return produtoService.listarProdutos().stream()
                .filter(produto -> produto.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint para listar todos os produtos
    @GetMapping
    public ResponseEntity<List<Produto>> listarProdutos() {
        return ResponseEntity.ok(produtoService.listarProdutos());
    }

    // Endpoint para deletar um produto por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarProduto(@PathVariable Long id) {
        try {
            Produto produto = produtoService.listarProdutos().stream()
                    .filter(p -> p.getId().equals(id))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado."));
            produtoService.deletarProduto(produto.getNome());
            return ResponseEntity.ok("Produto deletado com sucesso.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Endpoint para deletar um produto por nome
    @DeleteMapping("/nome/{nome}")
    public ResponseEntity<String> deletarProdutoPorNome(@PathVariable String nome) {
        try {
            produtoService.deletarProduto(nome);
            return ResponseEntity.ok("Produto deletado com sucesso.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}