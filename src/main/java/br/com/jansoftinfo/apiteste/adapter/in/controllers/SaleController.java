package br.com.jansoftinfo.apiteste.adapter.in.controllers;

import br.com.jansoftinfo.apiteste.adapter.out.dto.SaleOutDTO;
import br.com.jansoftinfo.apiteste.adapter.utils.Constants;
import br.com.jansoftinfo.apiteste.domain.ports.in.SaleInPort;
//import io.swagger.annotations.ApiOperation;
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

    @GetMapping
    //@ApiOperation(value = Constants.GET_SALES)
    public ResponseEntity<?> getSales() {
        return new ResponseEntity<List<SaleOutDTO>>(port.getSales(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    //@ApiOperation(value = Constants.GET_SALES_ID)
    public ResponseEntity<?> getSale(@PathVariable Long id) {
        return port.getSale(id);
    }

    @GetMapping("/query")
    //@ApiOperation(value = Constants.GET_SALES_QUERY)
    public ResponseEntity<?> getSalesByStatus(@RequestParam("saleStatus") String saleStatus) {
        return new ResponseEntity<List<SaleOutDTO>>(port.getSalesByStatus(saleStatus), HttpStatus.OK);
    }

    @GetMapping("/customers/{idCustomer}")
    //@ApiOperation(value = Constants.GET_SALES_ID_CUSTOMER)
    public ResponseEntity<?> getSalesByCustomerId(@PathVariable Long idCustomer) {
        return new ResponseEntity<List<SaleOutDTO>>(port.getSalesByCustomerId(idCustomer), HttpStatus.OK);
    }
}