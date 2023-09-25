package br.com.jansoftinfo.apiteste.adapter.in.controllers;

import br.com.jansoftinfo.apiteste.adapter.in.dto.CustomerDTO;
import br.com.jansoftinfo.apiteste.domain.ports.in.CustomerPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerPort customerPort;

    @GetMapping
    public ResponseEntity<?> getCustomers() {
        return new ResponseEntity<List<CustomerDTO>>(customerPort.getCustomers(), HttpStatus.OK);
    }

    @GetMapping("/query")
    public ResponseEntity<?> getCustomersByType(@RequestParam("customerType") String customerType) {
        return new ResponseEntity<List<CustomerDTO>>(customerPort.getCustomersByType(customerType), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomer(@PathVariable Long id) {
        return customerPort.getCustomer(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putCustomer(@PathVariable Long id, @Validated @RequestBody CustomerDTO customer) {
        return customerPort.putCustomer(id, customer);
    }

    @PostMapping
    public ResponseEntity<?> postCustomer(@Validated @RequestBody CustomerDTO customer) {
        return new ResponseEntity<CustomerDTO>(customerPort.postCustomer(customer), HttpStatus.CREATED);
    }
}
