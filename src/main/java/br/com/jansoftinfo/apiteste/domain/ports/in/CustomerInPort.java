package br.com.jansoftinfo.apiteste.domain.ports.in;

import br.com.jansoftinfo.apiteste.adapter.in.dto.CustomerInDTO;
import br.com.jansoftinfo.apiteste.adapter.out.dto.CustomerOutDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerInPort {
    List<CustomerOutDTO> getCustomers();

    ResponseEntity<?> getCustomer(Long id);

    List<CustomerOutDTO> getCustomersByType(String customerType);

    CustomerOutDTO postCustomer(CustomerInDTO customer);

    ResponseEntity<?> putCustomer(Long id, CustomerInDTO customer);
}
