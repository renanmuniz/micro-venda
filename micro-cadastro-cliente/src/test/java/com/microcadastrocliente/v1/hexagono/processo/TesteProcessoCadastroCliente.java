package com.microcadastrocliente.v1.hexagono.processo;

import com.microcadastrocliente.v1.hexagono.dominio.Cliente;
import com.microcadastrocliente.v1.hexagono.dominio.TesteCliente;
import com.microcadastrocliente.v1.hexagono.exceptions.ClienteNaoEncontradoException;
import com.microcadastrocliente.v1.hexagono.processo.imp.ProcessoCadastroClienteImp;
import com.microcadastrocliente.v1.hexagono.servicos.repositorio.jpa.mock.RepositorioCadastroClienteMockImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.validation.ValidationException;

public class TesteProcessoCadastroCliente {

    ProcessoCadastroClienteImp processo = new ProcessoCadastroClienteImp(new RepositorioCadastroClienteMockImp());

    @Test
    public void testeCadastrarNomeNulo() {
        try {
            Cliente cliente = TesteCliente.fabricarClienteValido();
            cliente.setNome(null);
            processo.cadastrar(cliente);
            Assertions.fail("Deveria validar nome nulo");
        } catch (ValidationException e) {
            System.out.println("Passou no teste: " + e.getMessage());
        }
    }

    @Test
    public void testeCadastrarSucesso() {
        try {
            Cliente cliente = TesteCliente.fabricarClienteValido();
            processo.cadastrar(cliente);
        } catch (ValidationException e) {
            Assertions.fail("Não deveria dar exception: " + e.getMessage());
        }
    }

    @Test
    public void testeBuscarPorIdNaoEncontrado() {
        try {
            System.out.println(processo.buscar(2L));
            Assertions.fail("Deveria retornar retornar exception de cliente não econtrado");
        } catch (ValidationException | ClienteNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testeBuscarPorIdEncontrado() {
        try {
            System.out.println(processo.buscar(1L));
        } catch (ValidationException | ClienteNaoEncontradoException e) {
            Assertions.fail("Deveria retornar um registro do mock: " + e.getMessage());
        }
    }


}
