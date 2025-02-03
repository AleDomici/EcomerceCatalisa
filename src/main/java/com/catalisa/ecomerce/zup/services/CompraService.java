package com.catalisa.ecomerce.zup.services;

import com.catalisa.ecomerce.zup.model.Cliente;
import com.catalisa.ecomerce.zup.model.Compra;
import com.catalisa.ecomerce.zup.model.Produto;
import com.catalisa.ecomerce.zup.repository.ClienteRepository;
import com.catalisa.ecomerce.zup.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class CompraService {
    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;

    public CompraService(ClienteRepository clienteRepository, ProdutoRepository produtoRepository) {
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
    }

    public void registrarCompra(Compra compra) {
        Cliente cliente = clienteRepository.findByCpf(compra.getCpfCliente())
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado."));

        Produto produto = produtoRepository.findById(compra.getIdProduto())
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado."));

        if (produto.getQuantidade() < compra.getQuantidade()) {
            throw new IllegalArgumentException("Produto em falta no estoque.");
        }

        produto.setQuantidade(produto.getQuantidade() - compra.getQuantidade());
    }
}