package br.com.jansoftinfo.apiteste.domain.ports.in;

import br.com.jansoftinfo.apiteste.adapter.in.dto.CustomerDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerPort {
    List<CustomerDTO> getCustomers();

    ResponseEntity<?> getCustomer(Long id);

    List<CustomerDTO> getCustomersByType(String customerType);

    CustomerDTO postCustomer(CustomerDTO customer);

    ResponseEntity<?> putCustomer(Long id, CustomerDTO customer);
}
