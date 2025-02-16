package com.amandazaine.pontoeletronico.api.services.impl;

import com.amandazaine.pontoeletronico.api.entities.EmpresaEntity;
import com.amandazaine.pontoeletronico.api.repositories.EmpresaRepository;
import com.amandazaine.pontoeletronico.api.services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmpresaServiceImpl implements EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    public Optional<EmpresaEntity> findByCnpj(String cnpj) {
        return Optional.ofNullable(empresaRepository.findByCnpj(cnpj));
    }

    @Override
    public EmpresaEntity save(EmpresaEntity empresaEntity) {
        return this.empresaRepository.save(empresaEntity);
    }
}
