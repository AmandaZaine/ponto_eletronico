package com.amandazaine.pontoeletronico.api.repositories;

import com.amandazaine.pontoeletronico.api.entities.FuncionarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true) // Todos os métodos desta classe são somente para leitura.
public interface FuncionarioRepository extends JpaRepository<FuncionarioEntity, Long> {

    FuncionarioEntity findByCpf(String cpf);

    FuncionarioEntity findByEmail(String email);

    FuncionarioEntity findByCpfOrEmail(String cpf, String email);
}