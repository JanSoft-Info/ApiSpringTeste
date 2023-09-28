package br.com.jansoftinfo.apiteste.adapter.out.mappers;

import br.com.jansoftinfo.apiteste.adapter.in.dto.CustomerDTO;
import br.com.jansoftinfo.apiteste.adapter.in.dto.OperationDTO;
import br.com.jansoftinfo.apiteste.adapter.in.dto.ReceivableDTO;
import br.com.jansoftinfo.apiteste.domain.entities.OperationEntity;
import br.com.jansoftinfo.apiteste.domain.entities.ReceivableEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OperationMapper {

    public List<OperationDTO> toDTO(List<OperationEntity> entity) {
        var operationsDTO = new ArrayList<OperationDTO>();
        entity.forEach(o -> {
            operationsDTO.add(getOperation(o));
        });
        return operationsDTO;
    }

    public OperationDTO toDTO(OperationEntity entity) {
        return getOperation(entity);
    }

    private static OperationDTO getOperation(OperationEntity entity) {
        return OperationDTO.builder()
                .operationId(entity.getOperationId())
                .operationValue(entity.getOperationValue())
                .operationDateTime(entity.getOperationDateTime())
                .operationStatus(entity.getOperationStatus())
                .customer(getCustomerDTO(entity))
                .receivables(getReceivableDTOS(entity))
                .build();
    }

    private static CustomerDTO getCustomerDTO(OperationEntity entity) {
        return CustomerDTO.builder()
                .customerId(entity.getCustomerEntity().getCustomerId())
                .documentId(entity.getCustomerEntity().getDocumentId())
                .customerName(entity.getCustomerEntity().getCustomerName())
                .customerType(entity.getCustomerEntity().getCustomerType())
                .build();
    }

    private static List<ReceivableDTO> getReceivableDTOS(OperationEntity entity) {
        List<ReceivableDTO> receivablesDTO = new ArrayList<>();
        List<ReceivableEntity> receivablesEntity = entity.getReceivablesEntity();
        receivablesEntity.forEach(r -> {
            receivablesDTO.add(
                    ReceivableDTO.builder()
                            .receivableId(r.getReceivableId())
                            .receivableDateTime(r.getReceivableDateTime())
                            .receivableDueDate(r.getReceivableDueDate())
                            .receivableValue(r.getReceivableValue())
                            .receivableType(r.getReceivableType())
                            .receivableStatus(r.getReceivableStatus())
                            .build());
        });
        return receivablesDTO;
    }
}