package com.amandazaine.pontoeletronico.api.repositories;

import com.amandazaine.pontoeletronico.api.entities.EmpresaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface EmpresaRepository extends JpaRepository<EmpresaEntity, Long> {

    //Indica que um método ou classe é usado somente para leitura.
    //Informa ao banco de dados que nenhuma operação de escrita será feita.
    @Transactional(readOnly = true)
    EmpresaEntity findByCnpj(String cnpj);

}
