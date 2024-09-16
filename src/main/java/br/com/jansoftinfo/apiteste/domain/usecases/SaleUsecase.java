package br.com.jansoftinfo.apiteste.domain.usecases;

import br.com.jansoftinfo.apiteste.adapter.out.dtos.SaleOutDTO;
import br.com.jansoftinfo.apiteste.adapter.out.dtos.SaleOutResumeDTO;
import br.com.jansoftinfo.apiteste.adapter.out.mappers.SaleOutMapper;
import br.com.jansoftinfo.apiteste.adapter.out.repositories.SaleRepository;
import br.com.jansoftinfo.apiteste.commons.messages.MessageFactory;
import br.com.jansoftinfo.apiteste.domain.entities.SaleEntity;
import br.com.jansoftinfo.apiteste.domain.exceptions.ErrorDTO;
import br.com.jansoftinfo.apiteste.domain.ports.in.SaleInPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
class SaleUsecase implements SaleInPort {
    private final MessageFactory msg;
    private final SaleOutMapper mapper;
    private final SaleRepository repository;


    @Override
    public List<SaleOutDTO> getSales() {
        List<SaleOutDTO> dto = mapper.toDTO(repository.findAll());
        return dto.stream()
                  .filter(c -> c.valor_venda().equals(
                          new BigDecimal("1240000.00")))
                  .toList();
    }

    @Override
    public List<SaleOutResumeDTO> getSalesResume() {
        return mapper.toDTOResume(repository.findAll());
    }

    @Override
    public List<SaleOutDTO> getSalesByStatus(String operationStatus) {
        return mapper.toDTO(repository.getSalesByStatus(operationStatus));
    }

    @Override
    public ResponseEntity<?> getSale(Long id) {
        var sale = findSaleById(id);
        if (sale.isPresent())
            return new ResponseEntity<>(mapper.toDTO(sale.get()), HttpStatus.OK);
        else
            return new ResponseEntity<>(ErrorDTO.builder()
                    .message(msg.get("error.venda.nao.encontrada"))
                    .build(), HttpStatus.OK);
    }

    @Override
    public List<SaleOutDTO> getSalesByCustomerId(Long id) {
        return mapper.toDTO(repository.getSalesByCustomerId(id));
    }

    private Optional<SaleEntity> findSaleById(Long id) {
        return repository.findById(id);
    }
}