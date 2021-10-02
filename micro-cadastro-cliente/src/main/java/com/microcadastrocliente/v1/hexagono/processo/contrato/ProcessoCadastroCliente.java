package com.microcadastrocliente.v1.hexagono.processo.contrato;

import com.microcadastrocliente.v1.hexagono.dominio.Cliente;
import com.microcadastrocliente.v1.hexagono.exceptions.ClienteNaoEncontradoException;

import java.util.List;

public interface ProcessoCadastroCliente {
    Cliente cadastrar(Cliente cliente);

    Cliente alterar(Cliente cliente);

    Cliente buscar(Long id) throws ClienteNaoEncontradoException;

    List<Cliente> listar();

    void excluir(Long id);
}
