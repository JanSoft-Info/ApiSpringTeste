package br.com.jansoftinfo.apiteste.adapter.out.repositories;

import br.com.jansoftinfo.apiteste.domain.entities.OperationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<OperationEntity, Long> {
}