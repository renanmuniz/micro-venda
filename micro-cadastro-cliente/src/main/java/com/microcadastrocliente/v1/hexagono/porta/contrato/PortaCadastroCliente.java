package com.microcadastrocliente.v1.hexagono.porta.contrato;

import com.microcadastrocliente.v1.hexagono.dominio.Cliente;
import com.microcadastrocliente.v1.hexagono.exceptions.ClienteNaoEncontradoException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PortaCadastroCliente {

    Cliente cadastrar(Cliente cliente);

    Cliente alterar(Cliente cliente);

    Cliente buscar(Long id) throws ClienteNaoEncontradoException;

    Page<Cliente> listar(Pageable pageable);

    void excluir(Long id);

}
