package com.microcadastrocliente.v1.rest.imp;

import com.microcadastrocliente.v1.hexagono.dominio.Cliente;
import com.microcadastrocliente.v1.hexagono.exceptions.ClienteNaoEncontradoException;
import com.microcadastrocliente.v1.hexagono.porta.contrato.PortaCadastroCliente;
import com.microcadastrocliente.v1.rest.RestVersion;
import com.microcadastrocliente.v1.rest.contrato.RestCadastroCliente;
import com.microcadastrocliente.v1.rest.fabrica.FabricaDTO;
import com.microcadastrocliente.v1.rest.fabrica.FabricaDominio;
import com.microcadastrocliente.v1.rest.form.ClienteForm;
import com.microcadastrocliente.v1.rest.to.ClienteDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(RestVersion.VERSAO + "cliente")
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

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<ClienteDTO> buscar(@PathVariable Long id) throws ClienteNaoEncontradoException {
        Cliente cliente = portaCadastroCliente.buscar(id);
        return ResponseEntity.ok(FabricaDTO.fabricarCliente(cliente));

    }

    @GetMapping()
    @Override
    public Page<ClienteDTO> listar(
            @PageableDefault(sort = "id", direction = Sort.Direction.ASC, page = 0, size = 10)
                    Pageable paginacao) {
        Page<Cliente> clientes = portaCadastroCliente.listar(paginacao);
        return FabricaDTO.converterPageCliente(clientes);

    }
}
