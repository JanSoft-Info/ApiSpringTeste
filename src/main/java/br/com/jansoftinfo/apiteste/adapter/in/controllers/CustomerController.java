package br.com.jansoftinfo.apiteste.adapter.in.controllers;

import br.com.jansoftinfo.apiteste.adapter.in.dto.CustomerDTO;
import br.com.jansoftinfo.apiteste.ports.in.CustomerPort;
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
    private final CustomerPort port;

    @GetMapping
    public ResponseEntity<?> getCustomers() {
        return new ResponseEntity<List<CustomerDTO>>(port.getCustomers(), HttpStatus.OK);
    }

    @GetMapping("/query")
    public ResponseEntity<?> getCustomersByType(@RequestParam("customerType") String customerType) {
        return new ResponseEntity<List<CustomerDTO>>(port.getCustomersByType(customerType), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomer(@PathVariable Long id) {
        return port.getCustomer(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putCustomer(@PathVariable Long id, @Validated @RequestBody CustomerDTO customer) {
        return port.putCustomer(id, customer);
    }

    @PostMapping
    public ResponseEntity<?> postCustomer(@Validated @RequestBody CustomerDTO customer) {
        return new ResponseEntity<CustomerDTO>(port.postCustomer(customer), HttpStatus.CREATED);
    }
}