package com.microcadastrocliente.v1.rest.imp;

import com.microcadastrocliente.v1.hexagono.dominio.Cliente;
import com.microcadastrocliente.v1.hexagono.porta.contrato.PortaCadastroCliente;
import com.microcadastrocliente.v1.rest.RestVersion;
import com.microcadastrocliente.v1.rest.contrato.RestCadastroCliente;
import com.microcadastrocliente.v1.rest.fabrica.FabricaDTO;
import com.microcadastrocliente.v1.rest.fabrica.FabricaDominio;
import com.microcadastrocliente.v1.rest.form.ClienteForm;
import com.microcadastrocliente.v1.rest.to.ClienteDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(RestVersion.VERSAO+"cliente")
public class RestCadastroClienteImp implements RestCadastroCliente {

    PortaCadastroCliente portaCadastroCliente;

    public RestCadastroClienteImp(PortaCadastroCliente portaCadastroCliente) {
        this.portaCadastroCliente = portaCadastroCliente;
    }

    @PostMapping
    @Transactional
    @Override
    public ResponseEntity<ClienteDTO> cadastrar(@RequestBody @Valid ClienteForm form, UriComponentsBuilder uriBuilder) {
        Cliente cliente = portaCadastroCliente.cadastrar(FabricaDominio.fabricarCliente(form));
        URI uri = uriBuilder.path("/cliente/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(FabricaDTO.fabricarCliente(cliente));
    }
}
