package br.com.jansoftinfo.apiteste.domain.ports.in;

import br.com.jansoftinfo.apiteste.adapter.out.dtos.SaleOutDTO;
import br.com.jansoftinfo.apiteste.adapter.out.dtos.SaleOutResumeDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SaleInPort {
    List<SaleOutDTO> getSales();

    List<SaleOutResumeDTO> getSalesResume();

    List<SaleOutDTO> getSalesByStatus(String operationStatus);

    ResponseEntity<?> getSale(Long id);

    List<SaleOutDTO> getSalesByCustomerId(Long id);
}