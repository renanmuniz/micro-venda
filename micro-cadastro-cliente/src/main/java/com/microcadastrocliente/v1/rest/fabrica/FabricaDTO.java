package com.microcadastrocliente.v1.rest.fabrica;

import com.microcadastrocliente.v1.hexagono.dominio.Cliente;
import com.microcadastrocliente.v1.rest.to.ClienteDTO;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;

public class FabricaDTO {
    public static ClienteDTO fabricarCliente(Cliente dominio) {
        return new ClienteDTO(
                dominio.getId(),
                dominio.getNome(),
                (dominio.getCpf()!=null) ? formatarCpf(dominio.getCpf().toString()) : null,
                (dominio.getCnpj()!=null) ? formatarCnpj(dominio.getCnpj().toString()) : null,
                dominio.getEndereco(),
                dominio.getCidade(),
                dominio.getEstado(),
                dominio.getTelefone(),
                dominio.getEmail()
        );
    }

    private static String formatarCpf(String texto)  {
        try {
            MaskFormatter mf = new MaskFormatter("###.###.###-##");
            mf.setValueContainsLiteralCharacters(false);
            return mf.valueToString(("00000000000" + texto).substring(texto.length()));
        } catch (ParseException e) {
            return texto;
        }
    }

    private static String formatarCnpj(String texto)  {
        try {
            MaskFormatter mf = new MaskFormatter("##.###.###/####-##");
            mf.setValueContainsLiteralCharacters(false);
            return mf.valueToString(("00000000000000" + texto).substring(texto.length()));
        } catch (ParseException e) {
            return texto;
        }
    }
}
