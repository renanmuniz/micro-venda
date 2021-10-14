package com.microcadastrocliente.v1.hexagono.servicos.repositorio.jpa.mock;

import com.microcadastrocliente.v1.hexagono.dominio.Cliente;
import com.microcadastrocliente.v1.hexagono.servicos.repositorio.jpa.RepositorioCadastroCliente;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class RepositorioCadastroClienteMockImp implements RepositorioCadastroCliente {
    @Override
    public Optional<Cliente> findById(Long id) {
        if (id % 2 != 0) {
            return Optional.of(
                    new Cliente(
                            "Renan Teste Mock",
                            "13869871075",
                            null,
                            "Rua Teste Mock 123",
                            "Londrina",
                            "PR",
                            "43912345678",
                            "renan_mock@gmail.com"
                    )
            );
        }
        return Optional.empty();
    }

    @Override
    public List<Cliente> findAll() {
        return null;
    }

    @Override
    public List<Cliente> findAll(Sort sort) {
        return null;
    }

    @Override
    public List<Cliente> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public <S extends Cliente> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Cliente> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Cliente> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Cliente> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Cliente getOne(Long aLong) {
        return null;
    }

    @Override
    public Cliente getById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Cliente> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Cliente> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public Page<Cliente> findAll(Pageable pageable) {
        System.out.println("RepositorioCadastroClienteMockImp -> listar todos." + pageable);
        List<Cliente> lista = new ArrayList<>();
        for(long i=0;i<10;i++) {
            Cliente cliente = new Cliente(
                    i,
                    "Cliente Mock Teste " + i,
                    "13869871075",
                    null,
                    "Rua Teste 123",
                    "Londrina",
                    "PR",
                    "43912345678",
                    "renan@gmail.com"
            );
            lista.add(cliente);
            System.out.println(cliente);
        }
        return new PageImpl<>(lista);
    }

    @Override
    public <S extends Cliente> S save(S entity) {
        System.out.println("RepositorioCadastroClienteMockImp -> cadastrar/alterar cliente." + entity);
        return null;
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Cliente cliente) {
        System.out.println("RepositorioCadastroClienteMockImp -> deletar cliente." + cliente);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Cliente> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Cliente> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Cliente> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Cliente> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Cliente> boolean exists(Example<S> example) {
        return false;
    }
}
