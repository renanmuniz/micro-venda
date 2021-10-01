package com.microcadastrocliente.v1.hexagono.servicos.repositorio.jpa;

import com.microcadastrocliente.v1.hexagono.dominio.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioCadastroCliente extends JpaRepository<Cliente, Long> {
}
