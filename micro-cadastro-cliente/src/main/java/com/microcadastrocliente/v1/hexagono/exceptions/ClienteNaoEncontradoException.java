package com.microcadastrocliente.v1.hexagono.exceptions;

public class ClienteNaoEncontradoException extends Exception{
    public ClienteNaoEncontradoException() {
        super("Cliente não encontrado.");
    }
}
