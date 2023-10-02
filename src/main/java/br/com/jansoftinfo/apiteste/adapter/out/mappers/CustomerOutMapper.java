package br.com.jansoftinfo.apiteste.adapter.out.mappers;

import br.com.jansoftinfo.apiteste.adapter.out.dto.CustomerOutDTO;
import br.com.jansoftinfo.apiteste.domain.entities.CustomerEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerOutMapper {

    public List<CustomerOutDTO> toDTO(List<CustomerEntity> customersEntity) {
        var customersDTO = new ArrayList<CustomerOutDTO>();
        customersEntity.forEach(c -> {
            customersDTO.add(CustomerOutDTO.builder()
                    .customerId(c.getCustomerId())
                    .documentId(c.getCustomerDocumentId())
                    .customerName(c.getCustomerName())
                    .customerType(c.getCustomerType())
                    .build());
        });
        return customersDTO;
    }

    public CustomerOutDTO toDTO(CustomerEntity customerEntity) {
        return CustomerOutDTO.builder()
                .customerId(customerEntity.getCustomerId())
                .documentId(customerEntity.getCustomerDocumentId())
                .customerName(customerEntity.getCustomerName())
                .customerType(customerEntity.getCustomerType())
                .build();
    }
}