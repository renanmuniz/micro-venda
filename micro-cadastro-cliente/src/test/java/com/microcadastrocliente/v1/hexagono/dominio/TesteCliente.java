package com.microcadastrocliente.v1.hexagono.dominio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.validation.ValidationException;

public class TesteCliente {

    public static Cliente fabricarClienteValido() {
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
    public void testeEnderecoNulo() {
        try {
            Cliente cliente = fabricarClienteValido();
            cliente.setEndereco(null);
            cliente.validar();
            Assertions.fail("Deveria validar endereco nulo");
        } catch (ValidationException e) {
            System.out.println("Passou no teste: " + e.getMessage());
        }
    }

    @Test
    public void testeEnderecoVazio() {
        try {
            Cliente cliente = fabricarClienteValido();
            cliente.setEndereco("");
            cliente.validar();
            Assertions.fail("Deveria validar endereco vazio");
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

    @Test
    public void testeCidadeNulo() {
        try {
            Cliente cliente = fabricarClienteValido();
            cliente.setCidade(null);
            cliente.validar();
            Assertions.fail("Deveria validar cidade nulo");
        } catch (ValidationException e) {
            System.out.println("Passou no teste: " + e.getMessage());
        }
    }

    @Test
    public void testeCidadeVazio() {
        try {
            Cliente cliente = fabricarClienteValido();
            cliente.setCidade("");
            cliente.validar();
            Assertions.fail("Deveria validar cidade vazio");
        } catch (ValidationException e) {
            System.out.println("Passou no teste: " + e.getMessage());
        }
    }

    @Test
    public void testeCidadeMax() {
        try {
            Cliente cliente = fabricarClienteValido();
            cliente.setCidade("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            cliente.validar();
            Assertions.fail("Deveria validar tamanho máximo da cidade");
        } catch (ValidationException e) {
            System.out.println("Passou no teste: " + e.getMessage());
        }
    }

    @Test
    public void testeEstadoNulo() {
        try {
            Cliente cliente = fabricarClienteValido();
            cliente.setEstado(null);
            cliente.validar();
            Assertions.fail("Deveria validar estado nulo");
        } catch (ValidationException e) {
            System.out.println("Passou no teste: " + e.getMessage());
        }
    }

    @Test
    public void testeEstadoVazio() {
        try {
            Cliente cliente = fabricarClienteValido();
            cliente.setEstado("");
            cliente.validar();
            Assertions.fail("Deveria validar estado vazio");
        } catch (ValidationException e) {
            System.out.println("Passou no teste: " + e.getMessage());
        }
    }

    @Test
    public void testeEstadoMax() {
        try {
            Cliente cliente = fabricarClienteValido();
            cliente.setEstado("aaa");
            cliente.validar();
            Assertions.fail("Deveria validar tamanho máximo do estado");
        } catch (ValidationException e) {
            System.out.println("Passou no teste: " + e.getMessage());
        }
    }

    @Test
    public void testeEmailNulo() {
        try {
            Cliente cliente = fabricarClienteValido();
            cliente.setEmail(null);
            cliente.validar();
            Assertions.fail("Deveria validar Email nulo");
        } catch (ValidationException e) {
            System.out.println("Passou no teste: " + e.getMessage());
        }
    }

    @Test
    public void testeEmailVazio() {
        try {
            Cliente cliente = fabricarClienteValido();
            cliente.setEmail("");
            cliente.validar();
            Assertions.fail("Deveria validar Email vazio");
        } catch (ValidationException e) {
            System.out.println("Passou no teste: " + e.getMessage());
        }
    }

    @Test
    public void testeEmailMax() {
        try {
            Cliente cliente = fabricarClienteValido();
            cliente.setEmail("aaaaaa@aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa.com");
            cliente.validar();
            Assertions.fail("Deveria validar tamanho máximo do Email");
        } catch (ValidationException e) {
            System.out.println("Passou no teste: " + e.getMessage());
        }
    }

    @Test
    public void testeEmailInvalido() {
        try {
            Cliente cliente = fabricarClienteValido();
            cliente.setEmail("renangmail.com");
            cliente.validar();
            Assertions.fail("Deveria validar Email inválido");
        } catch (ValidationException e) {
            System.out.println("Passou no teste: " + e.getMessage());
        }
    }

    @Test
    public void testeEmailInvalido2() {
        try {
            Cliente cliente = fabricarClienteValido();
            cliente.setEmail("renan@gmailcom");
            cliente.validar();
            Assertions.fail("Deveria validar Email inválido");
        } catch (ValidationException e) {
            System.out.println("Passou no teste: " + e.getMessage());
        }
    }

    @Test
    public void testeTelefoneInvalido() {
        try {
            Cliente cliente = fabricarClienteValido();
            cliente.setTelefone("123456789");
            cliente.validar();
            Assertions.fail("Deveria validar telefone inválido");
        } catch (ValidationException e) {
            System.out.println("Passou no teste: " + e.getMessage());
        }
    }

    @Test
    public void testeTelefoneInvalido2() {
        try {
            Cliente cliente = fabricarClienteValido();
            cliente.setTelefone("1234x6789");
            cliente.validar();
            Assertions.fail("Deveria validar telefone inválido");
        } catch (ValidationException e) {
            System.out.println("Passou no teste: " + e.getMessage());
        }
    }

    @Test
    public void testeCpfInvalido() {
        try {
            Cliente cliente = fabricarClienteValido();
            cliente.setCpf("79910483060");
            cliente.validar();
            Assertions.fail("Deveria validar cpf inválido");
        } catch (ValidationException e) {
            System.out.println("Passou no teste: " + e.getMessage());
        }
    }

    @Test
    public void testeCnpjInvalido() {
        try {
            Cliente cliente = fabricarClienteValido();
            cliente.setCnpj("16233322000119");
            cliente.validar();
            Assertions.fail("Deveria validar cnpj inválido");
        } catch (ValidationException e) {
            System.out.println("Passou no teste: " + e.getMessage());
        }
    }

    @Test
    public void testeRegraCpfCnpjNulosSimultaneamente() {
        try {
            Cliente cliente = fabricarClienteValido();
            cliente.setCpf(null);
            cliente.setCnpj(null);
            cliente.validar();
            Assertions.fail("Deveria validar regra de cpf e cnpj nulos simultaneamente inválido");
        } catch (ValidationException e) {
            System.out.println("Passou no teste: " + e.getMessage());
        }
    }

    @Test
    public void testeRegraCpfCnpjVaziosSimultaneamente() {
        try {
            Cliente cliente = fabricarClienteValido();
            cliente.setCpf("");
            cliente.setCnpj("");
            cliente.validar();
            Assertions.fail("Deveria validar regra de cpf e cnpj vazios simultaneamente inválido");
        } catch (ValidationException e) {
            System.out.println("Passou no teste: " + e.getMessage());
        }
    }

    @Test
    public void testeRegraCpfCnpjPreenchidosSimultaneamente() {
        try {
            Cliente cliente = fabricarClienteValido();
            cliente.setCnpj("16233322000110");
            cliente.validar();
            Assertions.fail("Deveria validar regra de cpf e cnpj preenchidos simultaneamente inválido");
        } catch (ValidationException e) {
            System.out.println("Passou no teste: " + e.getMessage());
        }
    }

    // ------------------------

    @Test
    public void testeCLienteValido() {
        Cliente cliente = fabricarClienteValido();
        try {
            cliente.validar();
            System.out.println(cliente);
        } catch (ValidationException e) {
            Assertions.fail("Não deveria dar erro: " + e.getMessage());
        }
    }
}
