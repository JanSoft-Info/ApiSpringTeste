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
            customersDTO.add(
                new CustomerOutDTO(
                    customer.getCustomerId(),
                    customer.getCustomerDocumentId(),
                    customer.getCustomerName(),
                    customer.getCustomerType()
                )
            );
        });
        return customersDTO;
    }

    public CustomerOutDTO toDTO(CustomerEntity customerEntity) {
        return new CustomerOutDTO(
            customerEntity.getCustomerId(),
            customerEntity.getCustomerDocumentId(),
            customerEntity.getCustomerName(),
            customerEntity.getCustomerType()
        );
    }
}