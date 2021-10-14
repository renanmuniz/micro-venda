package com.microcadastrocliente.v1.rest.to;

import com.microcadastrocliente.v1.hexagono.dominio.Cliente;
import com.microcadastrocliente.v1.rest.fabrica.FabricaDTO;

public class ClienteDTO {
    Long id;
    String nome;
    String cpf;
    String cnpj;
    String endereco;
    String cidade;
    String estado;
    String telefone;
    String email;

    public ClienteDTO(Long id, String nome, String cpf, String cnpj, String endereco, String cidade, String estado, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.telefone = telefone;
        this.email = email;
    }

    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf = (cliente.getCpf() != null) ? FabricaDTO.formatarCpf(cliente.getCpf()) : null;
        this.cnpj = (cliente.getCnpj() != null) ? FabricaDTO.formatarCnpj(cliente.getCnpj()) : null;
        this.endereco = cliente.getEndereco();
        this.cidade = cliente.getCidade();
        this.estado = cliente.getEstado();
        this.telefone = cliente.getTelefone();
        this.email = cliente.getEmail();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
