package com.microcadastrocliente.v1.hexagono.processo.contrato;

import com.microcadastrocliente.v1.hexagono.dominio.Cliente;
import com.microcadastrocliente.v1.hexagono.exceptions.ClienteNaoEncontradoException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProcessoCadastroCliente {
    Cliente cadastrar(Cliente cliente);

    Cliente alterar(Cliente cliente) throws ClienteNaoEncontradoException;

    Cliente buscar(Long id) throws ClienteNaoEncontradoException;

    Page<Cliente> listar(Pageable pageable);

    void excluir(Cliente cliente);
}
