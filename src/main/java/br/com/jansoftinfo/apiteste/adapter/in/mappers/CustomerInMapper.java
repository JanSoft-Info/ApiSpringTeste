package br.com.jansoftinfo.apiteste.adapter.in.mappers;

import br.com.jansoftinfo.apiteste.adapter.in.controllers.dto.CustomerInDTO;
import br.com.jansoftinfo.apiteste.domain.entities.CustomerEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomerInMapper {
    public CustomerEntity toEntity(CustomerInDTO customer) {
        return CustomerEntity.builder()
                .customerId(customer.getCustomerId())
                .customerName(customer.getCustomerName())
                .customerDocumentId(customer.getDocumentId())
                .customerType(customer.getCustomerType())
                .build();
    }
}