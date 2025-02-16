package com.amandazaine.pontoeletronico.api.services;

import com.amandazaine.pontoeletronico.api.entities.Empresa;

import java.util.Optional;

public interface EmpresaService {

    Optional<Empresa> findByCnpj(String cnpj);

    Empresa save(Empresa empresa);

}
