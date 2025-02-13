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
        // Normaliza o CPF para evitar problemas de formatação
        String cpfNormalizado = compra.getCpfCliente().replaceAll("\\D", "");

        // Busca o cliente pelo CPF
        Cliente cliente = clienteRepository.findByCpf(cpfNormalizado)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado."));

        // Busca o produto pelo ID
        Produto produto = produtoRepository.findById(compra.getIdProduto())
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado."));

        // Verifica se há estoque suficiente
        if (produto.getQuantidade() < compra.getQuantidade()) {
            throw new IllegalArgumentException("Produto em falta no estoque.");
        }

        // Atualiza a quantidade do produto no estoque
        produto.setQuantidade(produto.getQuantidade() - compra.getQuantidade());

        // Salva o estado atualizado do produto
        produtoRepository.save(produto);
    }
}