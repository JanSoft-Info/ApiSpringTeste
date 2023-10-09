package br.com.jansoftinfo.apiteste.domain.usecase;

import br.com.jansoftinfo.apiteste.adapter.out.dto.SaleOutDTO;
import br.com.jansoftinfo.apiteste.adapter.out.mappers.SaleOutMapper;
import br.com.jansoftinfo.apiteste.adapter.out.repositories.SaleRepository;
import br.com.jansoftinfo.apiteste.domain.entities.SaleEntity;
import br.com.jansoftinfo.apiteste.domain.exceptions.ErrorDTO;
import br.com.jansoftinfo.apiteste.domain.ports.in.SaleInPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
class SaleUsecase implements SaleInPort {
    private final SaleOutMapper mapper;
    private final SaleRepository repository;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("kafka.topic")
    private String TOPIC_NAME;

    @Override
    public void sendMessage(String message) {
        System.out.println(message);
        kafkaTemplate.send(TOPIC_NAME, message);
    }

    @Override
    public List<SaleOutDTO> getSales() {
        return mapper.toDTO(repository.findAll());
    }

    @Override
    public List<SaleOutDTO> getSalesByStatus(String operationStatus) {
        return mapper.toDTO(repository.getSalesByStatus(operationStatus));
    }

    @Override
    public ResponseEntity<?> getSale(Long id) {
        var operation = findOperationById(id);
        if (operation.isPresent())
            return new ResponseEntity<>(mapper.toDTO(operation.get()), HttpStatus.OK);
        else
            return new ResponseEntity<>(ErrorDTO.builder()
                    .message("Venda não encontrada")
                    .build(), HttpStatus.OK);
    }

    @Override
    public List<SaleOutDTO> getSalesByCustomerId(Long id) {
        return mapper.toDTO(repository.getSalesByCustomerId(id));
    }

    private Optional<SaleEntity> findOperationById(Long id) {
        return repository.findById(id);
    }
}