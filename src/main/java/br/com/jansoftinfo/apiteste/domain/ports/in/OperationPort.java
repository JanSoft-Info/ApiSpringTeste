package br.com.jansoftinfo.apiteste.domain.ports.in;

import br.com.jansoftinfo.apiteste.adapter.in.dto.OperationDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OperationPort {
    List<OperationDTO> getOperations();

    List<OperationDTO> getOperationsByStatus(String operationStatus);

    ResponseEntity<?> getOperation(Long id);

    List<OperationDTO> getOperationsByCustomerId(Long id);
}