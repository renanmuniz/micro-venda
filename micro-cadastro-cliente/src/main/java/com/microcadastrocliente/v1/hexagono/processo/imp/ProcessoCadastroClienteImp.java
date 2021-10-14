package com.microcadastrocliente.v1.hexagono.processo.imp;

import com.microcadastrocliente.v1.hexagono.dominio.Cliente;
import com.microcadastrocliente.v1.hexagono.exceptions.ClienteNaoEncontradoException;
import com.microcadastrocliente.v1.hexagono.processo.contrato.ProcessoCadastroCliente;
import com.microcadastrocliente.v1.hexagono.servicos.repositorio.jpa.RepositorioCadastroCliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProcessoCadastroClienteImp implements ProcessoCadastroCliente {

    RepositorioCadastroCliente repositorioCadastroCliente;

    public ProcessoCadastroClienteImp(RepositorioCadastroCliente repositorioCadastroCliente) {
        this.repositorioCadastroCliente = repositorioCadastroCliente;
    }

    /**
     * Para desenvolvimento com o repositorio mockado:
     **/
//    public ProcessoCadastroClienteImp(RepositorioCadastroClienteMockImp repositorioCadastroCliente) {
//        this.repositorioCadastroCliente = repositorioCadastroCliente;
//    }

    @Override
    public Cliente cadastrar(Cliente cliente) {
        cliente.validar();
        return repositorioCadastroCliente.save(cliente);
    }

    @Override
    public Cliente alterar(Cliente cliente) throws ClienteNaoEncontradoException {
        Optional<Cliente> clienteRep = repositorioCadastroCliente.findById(cliente.getId());
        if (clienteRep.isPresent()) {
            cliente.validar();
            return repositorioCadastroCliente.save(cliente);
        }
        throw new ClienteNaoEncontradoException();
    }

    @Override
    public Cliente buscar(Long id) throws ClienteNaoEncontradoException {
        Optional<Cliente> cliente = repositorioCadastroCliente.findById(id);
        if (cliente.isPresent()) {
            return cliente.get();
        }
        throw new ClienteNaoEncontradoException();
    }

    @Override
    public Page<Cliente> listar(Pageable pageable) {
        return repositorioCadastroCliente.findAll(pageable);
    }

    @Override
    public void excluir(Cliente cliente) {
        repositorioCadastroCliente.delete(cliente);
    }
}
