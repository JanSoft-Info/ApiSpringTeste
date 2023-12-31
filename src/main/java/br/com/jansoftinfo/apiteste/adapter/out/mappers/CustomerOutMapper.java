package br.com.jansoftinfo.apiteste.adapter.out.mappers;

import br.com.jansoftinfo.apiteste.adapter.out.dtos.CustomerOutDTO;
import br.com.jansoftinfo.apiteste.domain.entities.CustomerEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerOutMapper {

    public List<CustomerOutDTO> toDTO(List<CustomerEntity> customersEntity) {
        var customersDTO = new ArrayList<CustomerOutDTO>();
        customersEntity.forEach(customer -> {
            customersDTO.add(CustomerOutDTO.builder()
                    .customerId(customer.getCustomerId())
                    .documentId(customer.getCustomerDocumentId())
                    .customerName(customer.getCustomerName())
                    .customerType(customer.getCustomerType())
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