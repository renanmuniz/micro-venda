package com.example.microcadastrocliente.v1.hexagono.dominio;

import com.microcadastrocliente.v1.hexagono.dominio.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.validation.ValidationException;

public class TesteCliente {

    Cliente fabricarClienteValido() {
        return new Cliente(
                "Renan Teste",
                "13869871075",
                null,
                "Rua Teste 123",
                "Londrina",
                "PR",
                "43912345678",
                "renan@gmail.com"
        );
    }

    @Test
    public void testeNomeMax() {
        try {
            Cliente cliente = fabricarClienteValido();
            cliente.setNome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            cliente.validar();
            Assertions.fail("Deveria validar tamanho máximo do nome");
        } catch (ValidationException e) {
            System.out.println("Passou no teste: " + e.getMessage());
        }
    }

    @Test
    public void testeNomeNulo() {
        try {
            Cliente cliente = fabricarClienteValido();
            cliente.setNome(null);
            cliente.validar();
            Assertions.fail("Deveria validar nome nulo");
        } catch (ValidationException e) {
            System.out.println("Passou no teste: " + e.getMessage());
        }
    }

    @Test
    public void testeNomeVazio() {
        try {
            Cliente cliente = fabricarClienteValido();
            cliente.setNome("");
            cliente.validar();
            Assertions.fail("Deveria validar nome vazio");
        } catch (ValidationException e) {
            System.out.println("Passou no teste: " + e.getMessage());
        }
    }

    @Test
    public void testeEnderecoMax() {
        try {
            Cliente cliente = fabricarClienteValido();
            cliente.setEndereco("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            cliente.validar();
            Assertions.fail("Deveria validar tamanho máximo do endereco");
        } catch (ValidationException e) {
            System.out.println("Passou no teste: " + e.getMessage());
        }
    }
}
