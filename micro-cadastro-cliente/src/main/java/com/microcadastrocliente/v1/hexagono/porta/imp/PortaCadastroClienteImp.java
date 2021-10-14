package com.microcadastrocliente.v1.hexagono.porta.imp;

import com.microcadastrocliente.v1.hexagono.dominio.Cliente;
import com.microcadastrocliente.v1.hexagono.exceptions.ClienteNaoEncontradoException;
import com.microcadastrocliente.v1.hexagono.porta.contrato.PortaCadastroCliente;
import com.microcadastrocliente.v1.hexagono.processo.contrato.ProcessoCadastroCliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PortaCadastroClienteImp implements PortaCadastroCliente {

    ProcessoCadastroCliente processoCadastroCliente;

    public PortaCadastroClienteImp(ProcessoCadastroCliente processoCadastroCliente) {
        this.processoCadastroCliente = processoCadastroCliente;
    }

    @Override
    public Cliente cadastrar(Cliente cliente) {
        return processoCadastroCliente.cadastrar(cliente);
    }

    @Override
    public Cliente alterar(Cliente cliente) {
        return null;
    }

    @Override
    public Cliente buscar(Long id) throws ClienteNaoEncontradoException {
        return processoCadastroCliente.buscar(id);
    }

    @Override
    public Page<Cliente> listar(Pageable pageable) {
        return processoCadastroCliente.listar(pageable);
    }

    @Override
    public void excluir(Long id) {

    }
}
