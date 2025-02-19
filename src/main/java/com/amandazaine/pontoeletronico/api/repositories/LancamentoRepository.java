package com.amandazaine.pontoeletronico.api.repositories;

import com.amandazaine.pontoeletronico.api.entities.LancamentoEntity;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true) // Todos os métodos desta classe são somente para leitura.
@NamedQueries({
        @NamedQuery(
                    name = "LancamentoRepository.findByFuncionarioId",
                    query = "SELECT lanc FROM Lancamento lanc WHERE lanc.funcionario.id = :funcionarioId"
        )
})
public interface LancamentoRepository extends JpaRepository<LancamentoEntity, Long> {

    List<LancamentoEntity> findByFuncionarioId(@Param("funcionarioId") Long funcionarioId);

    Page<LancamentoEntity> findByFuncionarioId(@Param("funcionarioId") Long funcionarioId, Pageable pageable);
}
