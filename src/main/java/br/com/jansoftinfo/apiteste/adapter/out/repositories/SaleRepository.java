package br.com.jansoftinfo.apiteste.adapter.out.repositories;

import br.com.jansoftinfo.apiteste.domain.entities.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<SaleEntity, Long> {
    @Query(value = "select * from venda where status_venda = ?", nativeQuery = true)
    List<SaleEntity> getSalesByStatus(String operationStatus);

    @Query(value = "select * from venda where id_cliente = ?", nativeQuery = true)
    List<SaleEntity> getSalesByCustomerId(Long id);
}