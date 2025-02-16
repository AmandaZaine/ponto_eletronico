package com.amandazaine.pontoeletronico.api.services;

import com.amandazaine.pontoeletronico.api.entities.FuncionarioEntity;

import java.util.Optional;

public interface FuncionarioService {

    FuncionarioEntity save(FuncionarioEntity funcionarioEntity);
    Optional<FuncionarioEntity> findByCpf(String cpf);
    Optional<FuncionarioEntity> findByEmail(String email);
    Optional<FuncionarioEntity> findById(Long id);

}
