package com.microcadastrocliente.v1.hexagono.processo.contrato;

import com.microcadastrocliente.v1.hexagono.dominio.Cliente;

import java.util.List;

public interface ProcessoCadastroCliente {
    Cliente cadastrar(Cliente cliente);

    Cliente alterar(Cliente cliente);

    Cliente buscar(Long id);

    List<Cliente> listar();

    void excluir(Long id);
}
