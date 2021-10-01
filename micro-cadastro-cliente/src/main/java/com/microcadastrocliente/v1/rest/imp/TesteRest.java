package com.microcadastrocliente.v1.rest.imp;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
public class TesteRest {
    @GetMapping
    public ResponseEntity<String> testar() {


        return ResponseEntity.ok("Teste ok");

    }
}
