package com.microcadastrocliente.v1.rest.fabrica;

import com.microcadastrocliente.v1.hexagono.dominio.Cliente;
import com.microcadastrocliente.v1.rest.to.ClienteDTO;
import org.springframework.data.domain.Page;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;

public class FabricaDTO {
    public static ClienteDTO fabricarCliente(Cliente dominio) {
        return new ClienteDTO(
                dominio.getId(),
                dominio.getNome(),
                (dominio.getCpf() != null) ? formatarCpf(dominio.getCpf()) : null,
                (dominio.getCnpj() != null) ? formatarCnpj(dominio.getCnpj()) : null,
                dominio.getEndereco(),
                dominio.getCidade(),
                dominio.getEstado(),
                dominio.getTelefone(),
                dominio.getEmail()
        );
    }

    public static Page<ClienteDTO> converterPageCliente(Page<Cliente> clientes) {
        return clientes.map(ClienteDTO::new);
    }

    public static String formatarCpf(String texto) {
        try {
            MaskFormatter mf = new MaskFormatter("###.###.###-##");
            mf.setValueContainsLiteralCharacters(false);
            return mf.valueToString(("00000000000" + texto).substring(texto.length()));
        } catch (ParseException e) {
            return texto;
        }
    }

    public static String formatarCnpj(String texto) {
        try {
            MaskFormatter mf = new MaskFormatter("##.###.###/####-##");
            mf.setValueContainsLiteralCharacters(false);
            return mf.valueToString(("00000000000000" + texto).substring(texto.length()));
        } catch (ParseException e) {
            return texto;
        }
    }
}
