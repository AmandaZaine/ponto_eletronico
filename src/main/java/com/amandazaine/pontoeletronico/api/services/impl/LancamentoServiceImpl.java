package com.amandazaine.pontoeletronico.api.services.impl;

import com.amandazaine.pontoeletronico.api.entities.LancamentoEntity;
import com.amandazaine.pontoeletronico.api.repositories.LancamentoRepository;
import com.amandazaine.pontoeletronico.api.services.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;

public class LancamentoServiceImpl implements LancamentoService {

    @Autowired
    LancamentoRepository lancamentoRepository;

    @Override
    public Page<LancamentoEntity> findByFuncionarioId(Long funcionarioId, PageRequest pageRequest) {
        return lancamentoRepository.findByFuncionarioId(funcionarioId, pageRequest);
    }

    //Spring Cache: usada para armazenar em cache o resultado de um método.
    //Consulta primeiro o cache: Se já existir um valor em cache, ele é retornado. Se não, o método é executado e o resultado é armazenado.
    @Cacheable("lancamentoPorId")
    public Optional<LancamentoEntity> findById(Long id) {
        return Optional.ofNullable(lancamentoRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Lançamento não encontrado")));
    }

    //Usada para atualizar um cache existente sem removê-lo. Sempre executa o método e atualiza o cache com o novo valor retornado.
    @CachePut("lancamentoPorId")
    public LancamentoEntity save(LancamentoEntity lancamentoEntity) {
        return lancamentoRepository.save(lancamentoEntity);
    }

    @Override
    public void delete(Long id) {
        lancamentoRepository.deleteById(id);
    }
}
