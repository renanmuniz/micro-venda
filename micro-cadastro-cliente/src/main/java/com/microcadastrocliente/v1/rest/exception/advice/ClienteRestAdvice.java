package com.microcadastrocliente.v1.rest.exception.advice;

import com.microcadastrocliente.v1.hexagono.exceptions.ClienteNaoEncontradoException;
import com.microcadastrocliente.v1.rest.to.ErroDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;

@ControllerAdvice(basePackages = "com.microcadastrocliente.v1.rest.imp")
public class ClienteRestAdvice {
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ClienteNaoEncontradoException.class)
    public ErroDTO handleUserNotFound(
            ClienteNaoEncontradoException clienteNaoEncontradoException) {
        ErroDTO errorDTO = new ErroDTO();
        errorDTO.setStatus(HttpStatus.NOT_FOUND.value());
        errorDTO.setMessage("Usuário não encontrado.");
        errorDTO.setTimestamp(new Date());
        return errorDTO;
    }
}
