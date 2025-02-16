package com.amandazaine.pontoeletronico.api.services.impl;

import com.amandazaine.pontoeletronico.api.entities.Empresa;
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
    public Optional<Empresa> findByCnpj(String cnpj) {
        return Optional.ofNullable(empresaRepository.findByCnpj(cnpj));
    }

    @Override
    public Empresa save(Empresa empresa) {
        return this.empresaRepository.save(empresa);
    }
}
