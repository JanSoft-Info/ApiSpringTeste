package br.com.jansoftinfo.apiteste.domain.usecase;

import br.com.jansoftinfo.apiteste.adapter.in.dto.OperationDTO;
import br.com.jansoftinfo.apiteste.domain.exceptions.ErrorDTO;
import br.com.jansoftinfo.apiteste.adapter.out.mappers.OperationMapper;
import br.com.jansoftinfo.apiteste.adapter.out.repositories.OperationRepository;
import br.com.jansoftinfo.apiteste.domain.entities.OperationEntity;
import br.com.jansoftinfo.apiteste.domain.ports.in.OperationPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
class OperationUsecase implements OperationPort {
    private final OperationMapper mapper;
    private final OperationRepository repository;

    @Override
    public List<OperationDTO> getOperations() {
        return mapper.toDTO(repository.findAll());
    }

    @Override
    public List<OperationDTO> getOperationsByStatus(String operationStatus) {
        return mapper.toDTO(repository.getOperationsByStatus(operationStatus));
    }

    @Override
    public ResponseEntity<?> getOperation(Long id) {
        var operation = findOperationById(id);
        if (operation.isPresent())
            return new ResponseEntity<>(mapper.toDTO(operation.get()), HttpStatus.OK);
        else
            return new ResponseEntity<>(ErrorDTO.builder()
                    .message("Operação não encontrada")
                    .build(), HttpStatus.OK);
    }

    @Override
    public List<OperationDTO> getOperationsByCustomerId(Long id) {
        return mapper.toDTO(repository.getOperationsByCustomerId(id));
    }

    private Optional<OperationEntity> findOperationById(Long id) {
        return repository.findById(id);
    }
}