package com.amandazaine.pontoeletronico.api.services.impl;

import com.amandazaine.pontoeletronico.api.entities.FuncionarioEntity;
import com.amandazaine.pontoeletronico.api.repositories.FuncionarioRepository;
import com.amandazaine.pontoeletronico.api.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    @Override
    public FuncionarioEntity save(FuncionarioEntity funcionarioEntity) {
        return funcionarioRepository.save(funcionarioEntity);
    }

    @Override
    public Optional<FuncionarioEntity> findByCpf(String cpf) {
        return Optional.ofNullable(funcionarioRepository.findByCpf(cpf));
    }

    @Override
    public Optional<FuncionarioEntity> findByEmail(String email) {
        return Optional.ofNullable(funcionarioRepository.findByEmail(email));
    }

    @Override
    public Optional<FuncionarioEntity> findById(Long id) {
        return funcionarioRepository.findById(id);
    }
}
