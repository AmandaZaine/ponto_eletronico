package com.amandazaine.pontoeletronico.api.services;

import com.amandazaine.pontoeletronico.api.entities.Funcionario;

import java.util.Optional;

public interface FuncionarioService {

    Funcionario save(Funcionario funcionario);
    Optional<Funcionario> findByCpf(String cpf);
    Optional<Funcionario> findByEmail(String email);
    Optional<Funcionario> findById(Long id);

}
