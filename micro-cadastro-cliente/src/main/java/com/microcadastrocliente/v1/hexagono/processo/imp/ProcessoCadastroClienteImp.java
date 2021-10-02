package com.microcadastrocliente.v1.hexagono.processo.imp;

import com.microcadastrocliente.v1.hexagono.dominio.Cliente;
import com.microcadastrocliente.v1.hexagono.exceptions.ClienteNaoEncontradoException;
import com.microcadastrocliente.v1.hexagono.processo.contrato.ProcessoCadastroCliente;
import com.microcadastrocliente.v1.hexagono.servicos.repositorio.jpa.RepositorioCadastroCliente;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Cliente buscar(Long id) throws ClienteNaoEncontradoException {
        Optional<Cliente> cliente = repositorioCadastroCliente.findById(id);
        if(cliente.isPresent()) {
            return cliente.get();
        }
        throw new ClienteNaoEncontradoException();
    }

    @Override
    public List<Cliente> listar() {
        return null;
    }

    @Override
    public void excluir(Long id) {

    }
}
