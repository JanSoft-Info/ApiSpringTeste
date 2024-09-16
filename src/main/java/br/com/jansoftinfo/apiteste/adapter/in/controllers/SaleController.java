package br.com.jansoftinfo.apiteste.adapter.in.controllers;

import br.com.jansoftinfo.apiteste.adapter.out.dtos.SaleOutDTO;
import br.com.jansoftinfo.apiteste.adapter.out.dtos.SaleOutResumeDTO;
import br.com.jansoftinfo.apiteste.commons.Constants;
import br.com.jansoftinfo.apiteste.domain.ports.in.SaleInPort;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sales")
public class SaleController {
    private final SaleInPort port;

    @GetMapping(produces = Constants.HTTP_CONTENT_TYPE)
    @Operation(summary = Constants.GET_SALES)
    public ResponseEntity<?> getSales() {
        return new ResponseEntity<List<SaleOutDTO>>(port.getSales(), HttpStatus.OK);
    }

    @GetMapping(value = "/resume", produces = Constants.HTTP_CONTENT_TYPE)
    @Operation(summary = Constants.GET_SALES_RESUME)
    public ResponseEntity<?> getSalesResume() {
        return new ResponseEntity<List<SaleOutResumeDTO>>(port.getSalesResume(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = Constants.HTTP_CONTENT_TYPE)
    @Operation(summary = Constants.GET_SALES_ID)
    public ResponseEntity<?> getSale(@PathVariable Long id) {
        return port.getSale(id);
    }

    @GetMapping(value = "/query", produces = Constants.HTTP_CONTENT_TYPE)
    @Operation(summary = Constants.GET_SALES_QUERY)
    public ResponseEntity<?> getSalesByStatus(@RequestParam("saleStatus") String saleStatus) {
        return new ResponseEntity<List<SaleOutDTO>>(port.getSalesByStatus(saleStatus), HttpStatus.OK);
    }

    @GetMapping(value = "/customers/{idCustomer}", produces = Constants.HTTP_CONTENT_TYPE)
    @Operation(summary = Constants.GET_SALES_ID_CUSTOMER)
    public ResponseEntity<?> getSalesByCustomerId(@PathVariable Long idCustomer) {
        return new ResponseEntity<List<SaleOutDTO>>(port.getSalesByCustomerId(idCustomer), HttpStatus.OK);
    }
}