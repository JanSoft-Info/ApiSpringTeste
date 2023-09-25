package br.com.jansoftinfo.apiteste.adapter.out.repositories;

import br.com.jansoftinfo.apiteste.domain.entities.OperationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OperationRepository extends JpaRepository<OperationEntity, Long> {
    @Query(value = "select * from operacao where status_operacao = ?", nativeQuery = true)
    List<OperationEntity> getOperationsByStatus(String operationStatus);

    @Query(value = "select * from operacao where id_cliente = ?", nativeQuery = true)
    List<OperationEntity> getOperationsByCustomerId(Long id);
}