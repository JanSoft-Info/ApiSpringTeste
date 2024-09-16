package br.com.jansoftinfo.apiteste.domain.ports.in;

import br.com.jansoftinfo.apiteste.adapter.in.dtos.CustomerInDTO;
import br.com.jansoftinfo.apiteste.adapter.out.dtos.CustomerOutDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerInPort {
    List<CustomerOutDTO> getCustomers();

    ResponseEntity<?> getCustomerById(Long id);

    CustomerOutDTO getCustomerCache(Long id_cliente);

    List<CustomerOutDTO> getCustomersByType(String customerType);

    CustomerOutDTO postCustomer(CustomerInDTO customer);

    CustomerInDTO postCustomerInCache(CustomerInDTO customer);

    ResponseEntity<?> putCustomer(Long id, CustomerInDTO customer);
}