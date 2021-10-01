package com.microcadastrocliente.v1.hexagono.porta.imp;

import com.microcadastrocliente.v1.hexagono.dominio.Cliente;
import com.microcadastrocliente.v1.hexagono.porta.contrato.PortaCadastroCliente;
import com.microcadastrocliente.v1.hexagono.processo.contrato.ProcessoCadastroCliente;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PortaCadastroClienteImp implements PortaCadastroCliente {

    ProcessoCadastroCliente processoCadastroCliente;

    public PortaCadastroClienteImp(ProcessoCadastroCliente processoCadastroCliente) {
        this.processoCadastroCliente = processoCadastroCliente;
    }

    @Override
    public Cliente cadastrar(Cliente cliente) {
        System.out.println("PortaCadastroCliente: " + cliente.toString());
        return processoCadastroCliente.cadastrar(cliente);
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
