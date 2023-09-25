package br.com.jansoftinfo.apiteste.adapter.out.mappers;

import br.com.jansoftinfo.apiteste.adapter.in.dto.CustomerDTO;
import br.com.jansoftinfo.apiteste.domain.entities.CustomerEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerMapper {

    public List<CustomerDTO> toDTO(List<CustomerEntity> customersEntity) {
        var customersDTO = new ArrayList<CustomerDTO>();
        customersEntity.forEach(c -> {
            customersDTO.add(CustomerDTO.builder()
                    .customerId(c.getCustomerId())
                    .documentId(c.getDocumentId())
                    .customerName(c.getCustomerName())
                    .customerType(c.getCustomerType())
                    .build());
        });
        return customersDTO;
    }

    public CustomerDTO toDTO(CustomerEntity customerEntity) {
        return CustomerDTO.builder()
                .customerId(customerEntity.getCustomerId())
                .documentId(customerEntity.getDocumentId())
                .customerName(customerEntity.getCustomerName())
                .customerType(customerEntity.getCustomerType())
                .build();
    }

    public CustomerEntity toEntity(CustomerDTO customer) {
        return CustomerEntity.builder()
                .customerId(customer.getCustomerId())
                .customerName(customer.getCustomerName())
                .documentId(customer.getDocumentId())
                .customerType(customer.getCustomerType())
                .build();
    }
}