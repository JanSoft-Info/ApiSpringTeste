package br.com.jansoftinfo.apiteste.adapter.in.mappers;

import br.com.jansoftinfo.apiteste.adapter.in.dtos.CustomerInDTO;
import br.com.jansoftinfo.apiteste.domain.entities.CustomerEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomerInMapper {
    public CustomerEntity toEntity(CustomerInDTO customer) {
        return CustomerEntity.builder()
                .customerId(customer.getId_cliente())
                .customerName(customer.getNome_cliente())
                .customerDocumentId(customer.getCpf_cnpj_cliente())
                .customerType(customer.getTipo_cliente())
                .build();
    }
}