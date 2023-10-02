package br.com.jansoftinfo.apiteste.adapter.in.controllers;

import br.com.jansoftinfo.apiteste.adapter.in.dto.CustomerInDTO;
import br.com.jansoftinfo.apiteste.adapter.out.dto.CustomerOutDTO;
import br.com.jansoftinfo.apiteste.domain.ports.in.CustomerInPort;
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
    private final CustomerInPort port;

    @GetMapping
    public ResponseEntity<?> getCustomers() {
        return new ResponseEntity<List<CustomerOutDTO>>(port.getCustomers(), HttpStatus.OK);
    }

    @GetMapping("/{idCustomer}")
    public ResponseEntity<?> getCustomer(@PathVariable Long idCustomer) {
        return port.getCustomer(idCustomer);
    }

    @GetMapping("/query")
    public ResponseEntity<?> getCustomersByType(@RequestParam("customerType") String customerType) {
        return new ResponseEntity<List<CustomerOutDTO>>(port.getCustomersByType(customerType), HttpStatus.OK);
    }

    @PutMapping("/{idCustomer}")
    public ResponseEntity<?> putCustomer(@PathVariable Long idCustomer, @Validated @RequestBody CustomerInDTO customer) {
        return port.putCustomer(idCustomer, customer);
    }

    @PostMapping
    public ResponseEntity<?> postCustomer(@Validated @RequestBody CustomerInDTO customer) {
        return new ResponseEntity<CustomerOutDTO>(port.postCustomer(customer), HttpStatus.CREATED);
    }
}