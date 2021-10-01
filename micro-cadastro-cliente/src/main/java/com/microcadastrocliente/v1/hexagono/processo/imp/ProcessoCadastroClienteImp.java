package com.microcadastrocliente.v1.hexagono.processo.imp;

import com.microcadastrocliente.v1.hexagono.dominio.Cliente;
import com.microcadastrocliente.v1.hexagono.processo.contrato.ProcessoCadastroCliente;
import com.microcadastrocliente.v1.hexagono.servicos.repositorio.jpa.RepositorioCadastroCliente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessoCadastroClienteImp implements ProcessoCadastroCliente {

    RepositorioCadastroCliente repositorioCadastroCliente;

    public ProcessoCadastroClienteImp(RepositorioCadastroCliente repositorioCadastroCliente) {
        this.repositorioCadastroCliente = repositorioCadastroCliente;
    }

    @Override
    public Cliente cadastrar(Cliente cliente) {
        return repositorioCadastroCliente.save(cliente);
    }

    @Override
    public Cliente alterar(Cliente cliente) {
        return null;
    }

    @Override
    public Cliente buscar(Long id) {
        return null;
    }

    @Override
    public List<Cliente> listar() {
        return null;
    }

    @Override
    public void excluir(Long id) {

    }
}
