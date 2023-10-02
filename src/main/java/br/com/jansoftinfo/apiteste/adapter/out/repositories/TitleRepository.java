package br.com.jansoftinfo.apiteste.adapter.out.repositories;

import br.com.jansoftinfo.apiteste.domain.entities.TitleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TitleRepository extends JpaRepository<TitleEntity, Long> {
}
