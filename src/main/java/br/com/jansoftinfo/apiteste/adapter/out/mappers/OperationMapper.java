package br.com.jansoftinfo.apiteste.adapter.out.mappers;

import br.com.jansoftinfo.apiteste.adapter.in.dto.OperationDTO;
import br.com.jansoftinfo.apiteste.domain.entities.OperationEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OperationMapper {

    public List<OperationDTO> toDTO(List<OperationEntity> entity) {
        var operationsDTO = new ArrayList<OperationDTO>();
        entity.forEach(o -> {
            operationsDTO.add(OperationDTO.builder()
                    .operationId(o.getOperationId())
                    .customerId(o.getCustomerId())
                    .operationValue(o.getOperationValue())
                    .operationDateTime(o.getOperationDateTime())
                    .operationStatus(o.getOperationStatus())
                    .build());
        });
        return operationsDTO;
    }

    public OperationDTO toDTO(OperationEntity entity) {
        return OperationDTO.builder()
                .operationId(entity.getOperationId())
                .customerId(entity.getCustomerId())
                .operationValue(entity.getOperationValue())
                .operationDateTime(entity.getOperationDateTime())
                .operationStatus(entity.getOperationStatus())
                .build();
    }
}