package br.com.jansoftinfo.apiteste.adapter.out.repositories;

import br.com.jansoftinfo.apiteste.domain.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
    @Query(value = "select * from cliente where tipo_cliente = ?", nativeQuery = true)
    List<CustomerEntity> getCustomerByType(@Param("customerType") String customerType);
}