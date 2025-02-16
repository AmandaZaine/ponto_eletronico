package com.amandazaine.pontoeletronico.api.services;

import com.amandazaine.pontoeletronico.api.entities.LancamentoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;

public interface LancamentoService {

    //Page é uma interface do Spring Data usada para trabalhar com paginação de dados.
    //A interface Page<T> encapsula uma lista paginada de resultados.
    Page<LancamentoEntity> findByFuncionarioId(Long funcionarioId, PageRequest pageRequest);

    Optional<LancamentoEntity> findById(Long id);

    LancamentoEntity save(LancamentoEntity lancamentoEntity);

    void delete(Long id);

}
