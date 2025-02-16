package com.amandazaine.pontoeletronico.api.services;

import com.amandazaine.pontoeletronico.api.entities.EmpresaEntity;

import java.util.Optional;

public interface EmpresaService {

    Optional<EmpresaEntity> findByCnpj(String cnpj);

    EmpresaEntity save(EmpresaEntity empresaEntity);

}
