package br.com.jansoftinfo.apiteste.adapter.out.repositories;

import br.com.jansoftinfo.apiteste.domain.entities.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SaleRepository extends JpaRepository<SaleEntity, Long> {
    @Query(value = "select * from venda where status_venda = ?", nativeQuery = true)
    List<SaleEntity> getSalesByStatus(String operationStatus);

    @Query(value = "select * from venda where id_cliente_venda = ?", nativeQuery = true)
    List<SaleEntity> getSalesByCustomerId(Long id);
}