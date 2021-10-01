package com.microcadastrocliente.v1.rest.fabrica;

import com.microcadastrocliente.v1.hexagono.dominio.Cliente;
import com.microcadastrocliente.v1.rest.form.ClienteForm;

public class FabricaDominio {
    public static Cliente fabricarCliente(ClienteForm form) {
        return new Cliente(
                form.getNome(),
                (form.getCpf()!="") ? form.getCpf() : null,
                (form.getCnpj()!="") ? form.getCnpj() : null,
                form.getEndereco(),
                form.getCidade(),
                form.getEstado(),
                form.getTelefone(),
                form.getEmail()
        );
    }
}
