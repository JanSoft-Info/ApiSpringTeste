package br.com.jansoftinfo.apiteste.adapter.in.controllers;

import br.com.jansoftinfo.apiteste.adapter.in.dtos.CustomerInDTO;
import br.com.jansoftinfo.apiteste.adapter.out.dtos.CustomerOutDTO;
import br.com.jansoftinfo.apiteste.adapter.utils.Constants;
import br.com.jansoftinfo.apiteste.domain.ports.in.CustomerInPort;
import io.swagger.v3.oas.annotations.Operation;
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

    @GetMapping(produces = Constants.HTTP_CONTENT_TYPE)
    @Operation(summary = Constants.GET_CUSTOMERS)
    public ResponseEntity<?> getCustomers() {
        return new ResponseEntity<List<CustomerOutDTO>>(port.getCustomers(), HttpStatus.OK);
    }

    @GetMapping(value = "/{idCustomer}", produces = Constants.HTTP_CONTENT_TYPE)
    @Operation(summary = Constants.GET_CUSTOMERS_ID)
    public ResponseEntity<?> getCustomer(@PathVariable Long idCustomer) {
        return port.getCustomer(idCustomer);
    }

    @GetMapping(value = "/query", produces = Constants.HTTP_CONTENT_TYPE)
    @Operation(summary = Constants.GET_CUSTOMERS_QUERY)
    public ResponseEntity<?> getCustomersByType(@RequestParam("customerType") String customerType) {
        return new ResponseEntity<List<CustomerOutDTO>>(port.getCustomersByType(customerType), HttpStatus.OK);
    }

    @PutMapping(value = "/{idCustomer}", consumes = Constants.HTTP_CONTENT_TYPE, produces = Constants.HTTP_CONTENT_TYPE)
    @Operation(summary = Constants.PUT_CUSTOMERS_ID)
    public ResponseEntity<?> putCustomer(@PathVariable Long idCustomer, @Validated @RequestBody CustomerInDTO customer) {
        return port.putCustomer(idCustomer, customer);
    }

    @PostMapping(consumes = Constants.HTTP_CONTENT_TYPE, produces = Constants.HTTP_CONTENT_TYPE)
    @Operation(summary = Constants.POST_CUSTOMERS)
    public ResponseEntity<?> postCustomer(@Validated @RequestBody CustomerInDTO customer) {
        return new ResponseEntity<CustomerOutDTO>(port.postCustomer(customer), HttpStatus.CREATED);
    }
}