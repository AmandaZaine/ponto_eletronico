package com.amandazaine.pontoeletronico.api.services;

import com.amandazaine.pontoeletronico.api.entities.Lancamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;

public interface LancamentoService {

    //Page é uma interface do Spring Data usada para representar paginação de dados.
    //A interface Page<T> encapsula uma lista paginada de resultados, contendo:
    //os dados da página atual (getContent()),
    //informações sobre a página atual (número, total de páginas),
    //total de elementos disponíveis (getTotalElements()),
    //total de páginas (getTotalPages()).
    Page<Lancamento> findFuncionarioById(Long funcionarioId, PageRequest pageRequest);

    Optional<Lancamento> findById(Long id);

    Lancamento save(Lancamento lancamento);

    void delete(Long id);

}
