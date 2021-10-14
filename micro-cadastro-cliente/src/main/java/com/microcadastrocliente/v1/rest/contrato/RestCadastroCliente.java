package com.microcadastrocliente.v1.rest.contrato;

import com.microcadastrocliente.v1.hexagono.exceptions.ClienteNaoEncontradoException;
import com.microcadastrocliente.v1.rest.form.ClienteForm;
import com.microcadastrocliente.v1.rest.to.ClienteDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

public interface RestCadastroCliente {

    ResponseEntity<ClienteDTO> cadastrar(ClienteForm form, UriComponentsBuilder uriBuilder);

    ResponseEntity<ClienteDTO> buscar(Long id) throws ClienteNaoEncontradoException;

    Page<ClienteDTO> listar(Pageable paginacao);

}
